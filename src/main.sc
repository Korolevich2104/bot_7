require: slotfilling/slotFilling.sc
  module = sys.zb-common
theme: /

    state: Start
        q!: $regex</start>
        a: Начнём.

    state: Hello
        intent!: /* (привет/здравствуй*/~добрый *(~утро/~день/~вечер/~ночь)) *
        random:
            a: Добрый день!
            a: Здравствуйте!
            a: Приветствую!

    state: weather
        intent!: /* (погода/* градусов */ * ~дождь*) *
        random:
            a: Погода на сегодня прекрасная!
            a: Погода сегодня хуже некуда...
            a: Я бы посоветовал Вам сегодня остаться дома и посмотреть сериал.
        
    state: currency 
        intent!: /* (курс/*сколько*/*~евро*/*~доллар*) *
        a: Курс доллара составляет 30.01 рублей. Курс евро составляет 40.02 рублей.
            
    state: NoMatch
        event!: noMatch
        random:
            a: Я не понял. Вы сказали: {{$request.query}} 
            a: Извините, я Вас не понял :(
        random:
            a: Попробуйте сказать по-другому.
            a: Переформулируйте пожалуйста.
            
    state: Match
        event!: match
        a: {{$context.intent.answer}}