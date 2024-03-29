
Der Shop wurde von Alexandre Samson erstellt.  
Jüchen 06.07.2023 bis 12.07.2023

## Danke
Für Hilfe bei der Erstellung dieses Projekts danke ich:  
Gordon Lucas  
Viktor Schäfer   
Xenia Skornjakow  
https://developer.alexanderklimov.ru/android/index.php  
https://ru.stackoverflow.com  
https://kotlinlang.ru  
https://www.youtube.com/watch?v=30tchn0TjaM&t=2097s  
https://www.youtube.com/watch?v=UMvhLSCYz2E  

Der Shop ist eine einfache Implementierung eines Online-Shops. Es ermöglicht Benutzern die Registrierung, Anmeldung,
Produktsuche, Hinzufügen von Produkten zum Warenkorb und Bezahlung der Produkte.<br>Es bietet auch eine Administrator-Funktionalität
zum Verwalten von Produkten und Benutzerkonten.

## Konzepte und Designentscheidungen im Shop:
[1] - Klassen und Vererbung:
   - Im Shop gibt es verschiedene Klassen, und verschiedene Funktionen.  
   - Die Klassen Account, UserAccount und AdminAccount repräsentieren Benutzerkonten mit unterschiedlichen Berechtigungen und Funktionen.  
   - Die Klasse Product repräsentiert ein Produkt mit Eigenschaften wie Name, Preis, Menge und Kategorien.  
   - Die Klasse Warenkorb repräsentiert den Warenkorb eines Benutzers mit Funktionen zum Hinzufügen, Entfernen und Berechnen des Gesamtpreises der Produkte.  

[2] - Listen und Datenhaltung:
   - Der Shop verwendet Listen, um Benutzerkonten, Produkte und den Warenkorb zu speichern fon Produkten.  
   - Die Klasse AccountManagement enthält separate Listen für Benutzerkonten (userAccounts) und Administrator-Konten (adminAccounts).  
   -  Die Klasse AccountManagement enthält auch eine Liste (productsList) zur Speicherung aller verfügbaren Produkte im Shop.  

[3] - Funktionen und Methoden:
   - Der Shop enthält verschiedene Funktionen und Methoden, um Aktionen wie Registrierung, Anmeldung, Produktverwaltung, Warenkorbverwaltung und Bezahlung durchzuführen.  
   - Die Funktionen sind modular aufgebaut, um die Code-Wiederverwendbarkeit und - Lesbarkeit zu verbessern.  
   - Zum Beispiel enthält die Funktion registerAccount in AccountManagement Logik zum Überprüfen von Benutzereingaben und zur Erstellung neuer Konten.  

[4] - Fehlerbehandlung und Exceptions:
   - Der Shop verwendet Exceptions, um Fehler und ungültige Zustände zu erkennen und entsprechend zu reagieren.  
   - Zum Beispiel wird eine InvalidInputException geworfen, wenn ungültige Benutzereingaben festgestellt werden.  
   - Eine UserNotFoundException wird geworfen, wenn ein Benutzerkonto nicht gefunden wird.  
   - Eine InvalidProductException wird geworfen, wenn ein ungültiges Produkt im Warenkorb festgestellt wird.  

[5] - Benutzerschnittstelle (CLI):
   - Der Shop verwendet eine Command-Line-Interface (CLI), um mit Benutzern zu interagieren.  
   - Benutzer können über die Konsole verschiedene Optionen auswählen, um Aktionen im Shop durchzuführen.  
   - Die Benutzerschnittstelle ist einfach gehalten, um die Benutzerfreundlichkeit und Verständlichkeit zu verbessern.  
   - Diese Designentscheidungen wurden getroffen, um die grundlegenden Funktionen eines Online-Shops zu implementieren
   - und die Code-Wartbarkeit und -Lesbarkeit zu verbessern. Natürlich kann der Code entsprechend den spezifischen Anforderungen
   - und Präferenzen weiter angepasst und erweitert werden.
## Klassenbeschreibung
[1] - AccountManagement:
   - Diese Klasse ist für das Management der Benutzer - und Administrator - Konten im Shop verantwortlich.  
   - Sie enthält private Listen (userAccounts, adminAccounts), um die Benutzer - und Administrator - Konten zu speichern.  
   - Die Klasse bietet Funktionen zum Registrieren von Benutzerkonten, Hinzufügen von Produkten, Entfernen von Produkten und Anzeigen der Produktliste.  
   - Die Funktionen registerAccount und login ermöglichen die Registrierung und Anmeldung von Benutzerkonten.  

[2] - Account:
   - Diese abstrakte Klasse stellt die Grundlage für Benutzer - und Administrator - Konten dar.  
   - Sie enthält Eigenschaften wie Benutzernamen und Passwort.  
   - Die abgeleiteten Klassen UserAccount und AdminAccount erweitern diese Klasse und fügen spezifische Funktionen und Eigenschaften hinzu.  

[3] - UserAccount:
   - Diese Klasse repräsentiert ein Benutzerkonto im Shop.  
   - Sie erbt von der Klasse Account und enthält zusätzliche Funktionen und Eigenschaften, die für Benutzerkonten relevant sind.  
   - Die Klasse ermöglicht das Hinzufügen und entfernen von Produkten zum Warenkorb, das Abrufen des Warenkorbs und die Bezahlung der Produkte.  

[4] - AdminAccount:
   - Diese Klasse repräsentiert ein Administrator-Konto im Shop.  
   - Sie erbt von der Klasse Account und enthält zusätzliche Funktionen und Eigenschaften, die für Administrator-Konten relevant sind.  
   - Die Klasse ermöglicht das Hinzufügen und entfernen von Produkten zur Produktliste und das Erstellen zufälliger Produkte.  

[5] - Product:
   - Diese Klasse repräsentiert ein Produkt im Shop.  
   - Sie enthält Eigenschaften wie Name, Preis, Menge, Kategorie und Unterkategorie.  
   - Die Klasse ermöglicht das Abrufen und ändern der Produktinformationen.  

[6] - Warenkorb:
   - Diese Klasse repräsentiert den Warenkorb eines Benutzers im Shop.  
   - Sie enthält eine Liste (products) zur Speicherung der hinzugefügten Produkte.  
   - Die Klasse bietet Funktionen zum Hinzufügen, entfernen und Abrufen von Produkten aus dem Warenkorb sowie zur Berechnung des Gesamtpreises.  

[7] - PaymentMethod:
   - Dies ist eine Enumeration, die verschiedene zahlungsmethoden im Shop repräsentiert, wie z.B. Kreditkarte und PayPal.  
   - Jede Zahlungsmethode hat eine makePayment-Funktion, die die Zahlung durchführt und einen Boolean-Wert zurückgibt, der den Erfolg der Zahlung angibt.  
## Funktionalitäten
[1] - Registrierung:
   - Benutzer können sich registrieren, indem sie einen Benutzernamen und ein Passwort eingeben.  
   - Sie können wählen, ob sie ein normales Benutzerkonto oder ein Administrator-Konto erstellen möchten.  

[2] - Anmeldung:
   - Benutzer können sich mit ihren Benutzernamen und Passwörtern anmelden.  
   - Das System überprüft die eingegebenen daten und gewährt den Zugriff auf das entsprechende Benutzerkonto.  

[3] - Produktsuche:
   - Benutzer und Administratoren können die verfügbaren Produkte im Shop anzeigen.  
   - Die Produkte werden mit Namen, Preis, Menge, Kategorie und Unterkategorie angezeigt.  

[4] - Warenkorb:
   - Benutzer können Produkte zum Warenkorb Hinzufügen und daraus Entfernen.  
   - Der Warenkorb speichert die ausgewählten Produkte eines Benutzers.  
   - Benutzer können den gesamtpreis der Produkte im Warenkorb anzeigen.  

[5] - Bezahlung:
   - Benutzer können den Bezahlungsprozess starten, um ihre Produkte zu bezahlen.  
   - Sie können zwischen verschiedenen Zahlungsmethoden wie Kreditkarte oder PayPal wählen.  
   - Der Bezahlungsprozess überprüft den gesamtpreis der Produkte und führt die zahlung durch.  

[6] - Administrator-Funktionalität:
   - Administratoren haben erweiterte berechtigungen im System.  
   - Sie können Produkte Hinzufügen und Entfernen.  
   - Administratoren können auch zwischen dem Administrator- und Benutzerkonto wechseln.  
## Verwendung des Shops
[1]- Registrierung:
   - Wählen Sie die Option "Registrieren".  
   - Geben Sie einen Benutzernamen und ein Passwort ein.  
   - Wählen Sie, ob Sie ein normales Benutzerkonto oder ein Administrator-Konto erstellen möchten.  

[2] - Anmeldung:
   - Wählen Sie die Option "Einloggen".  
   - Geben Sie Ihren Benutzernamen und Ihr Passwort ein.  
   - Das System überprüft Ihre Daten und gewährt den Zugriff auf ihr Konto.  

[3] - Produktsuche:
   - Wählen Sie die Option "Produkte anzeigen".  
   - Die verfügbaren Produkte werden mit ihren Details angezeigt.  

[4] - Warenkorb:
   - Wählen Sie die Option "Produkt zum Warenkorb Hinzufügen", um ein Produkt in den Warenkorb zu legen.  
   - Wählen Sie die Option "Produkt aus dem Warenkorb Entfernen", um ein Produkt aus dem Warenkorb zu entfernen.  
   - Wählen Sie die Option "Gesamtpreis im Warenkorb anzeigen", um den Gesamtpreis der Produkte im Warenkorb zu sehen.  


[5] - Bezahlung:
   - Wählen Sie die Option "Bezahlung", um den Bezahlungsprozess zu starten.  
   - Wählen Sie eine zahlungsmethode (Kreditkarte oder PayPal).  
   - Der Bezahlungsprozess überprüft den gesamtpreis und führt die zahlung durch.  

[6] - Administrator-Funktionalität:
   - Administratoren haben Zugriff auf erweiterte Optionen im Shop.  
   - Wählen Sie die Option "Zu Benutzerkonto wechseln", um zum Benutzerkonto zu wechseln.  
   - Wählen Sie die Option "Produkt Hinzufügen", um neue Produkte zum Shop hinzuzufügen.  
   - Wählen Sie die Option "Produkt Entfernen", um vorhandene Produkte aus dem Shop zu entfernen.  
   - Wählen Sie die Option "Zufällige Produkte erstellen", um automatisch zufällige Produkte zu erstellen.  
## Hinweise
- Stellen Sie sicher, dass Sie gültige Eingaben machen und alle Anweisungen befolgen.  
- Überprüfen Sie immer den Status des Warenkorbs, bevor Sie die Bezahlung durchführen.  
- Denken Sie daran, sich abzumelden, wenn Sie den Shop verlassen möchten.  

- Vielen Dank für die Nutzung des Shops! Wenn Sie weitere Fragen haben, stehe ich Ihnen gerne zur Verfügung.
