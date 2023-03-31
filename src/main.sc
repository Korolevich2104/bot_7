theme: /

    state: Start
        q!: $regex</start>
        a: Начнём.

    state: /begin
        intent: /привет
        go!: /hello
            
    state: /hello
        random:
            a: Добрый день!
            a: Здравствуйте!
            a: Приветствую!            

    state: /q1
        intent: /погода
        go!: /weather

    state: /weather
        random:
            a: Погода на сегодня прекрасная!
            a: Погода сегодня хуже некуда...
            a: Я бы посоветовал Вам сегодня остаться дома и посмотреть сериал.
            
            
    state: /q2
        intent: /курс
        go!: /currency

    state: /currency
        a: Курс доллара составляет 30.01 рублей. Курс евро составляет 40.02 рублей.
            
    state: /NoMatch
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