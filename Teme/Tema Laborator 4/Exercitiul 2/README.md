# Exercitiul 2:

## a.
Definiți clasa Form cu un membru color de tip String, o metoda getArea() care pentru început va intoarce 0 și o metodă toString() care va returna acestă culoare.
Clasa va avea, de asemenea:
- un constructor fără parametri;
- un constructor ce va inițializa culoarea.

## b.
Din clasa Form derivați clasele Triangle și Circle:
- clasa Triangle va avea 2 membri height si base de tip float;
- clasa Circle va avea membrul radius de tip float.
Clasele vor avea:
- constructori fără parametri
- constructori care permit inițializarea membrilor. Identificați o modalitate de reutilizare a codului existent.

## c.
Instanțiati clasele Triangle și Circle și apelați metoda toString() pentru fiecare instanță.
Suprascrieti metoda getArea() pentru a intoarce aria specifica figurii geometrice.

## d. 
Adăugați metode toString() în cele două clase derivate care să returneze tipul obiectului, culoarea si aria. De exemplu:
- pentru clasa Triangle, se va afișa: “Triunghi: rosu 10”
- pentru clasa Circle, se va afișa: “Cerc: verde 12.56”
Modificați implementarea toString() din clasele derivate astfel încât aceasta să utilizeze implementarea metodei toString() din clasa de bază.

## e. 
Adăugați o metodă equals() în clasa Triangle. Justificați criteriul de echivalentă ales.

## f. 
Creați un vector de obiecte Form și populați-l cu obiecte de tip Triangle și Circle (upcasting).
Parcurgeți acest vector și apelați metoda toString() pentru elementele sale. Ce observați?

## g.
Adăugați clasei Triangle metoda printTriangleDimensions() și clasei Circle metoda printCircleDimensions(). Implementarea metodelor constă în afișarea bazei si inaltimii, respectiv razei.
Parcurgeți vectorul de la exercițiul anterior și, folosind downcasting la clasa corespunzătoare, apelați metodele specifice fiecărei clase (printTriangleDimensions pentru Triangle și printCircleDimensions pentru Circle).
Pentru a stabili tipul obiectului curent folosiți operatorul instanceof.

## h. 
Adaugati o implementare la programul anterior astfel încât să nu mai folositi operatorul "instanceof".
