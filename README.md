# Horus

Zadanie Rekrutacyjne

## Opis Implementacji Metod w Klasie Wall

Zgodnie z treścią zadania zaimplementowałem metody w klasie `Wall`, uwzględniając jednocześnie implementację `CompositeBlock`. Podejście do implementacji metod oparłem na mojej interpretacji przeanalizowanego kodu.

### Metoda `findBlockByColor`

Metoda `findBlockByColor` zwraca pierwszy blok posiadający wartość koloru pasującą do pożądanej. Nie bierze pod uwagę kolorów bloków składających się na kompozyt. Jeśli dany blok nie zostanie znaleziony, metoda zwraca pusty obiekt `Optional`.

### Metoda `findBlocksByMaterial`

Metoda `findBlocksByMaterial` zwraca listę bloków posiadających wartość materiału pasującą do pożądanej. W tym przypadku, materiał bloków składowych kompozytu jest brany pod uwagę. Jeśli szukany materiał sam w sobie nie jest kompozytem.

### Metoda `count`

Metoda `count` zwraca ilość bloków w ścianie.

## Testy

W kodzie zawarłem również testy jednostkowe dla klasy `Wall`, które pokrywają implementowane metody. Testy te można znaleźć w pliku testowym `WallTest.java`.
