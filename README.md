# Project Work Biblioteca

   1. Tecnologie utilizzate

	
    • Database MySql vers. 8.
    • WebServer Tomcat 9.
    • Java JDK 8.
    • Servlet/Jsp
    • Web Service RestFul

   2. Struttura del Progetto
   
    L’applicazione verrà realizzata secondo il Pattern MVC
   3. Descrizione entità
   
	Le entità saranno le seguenti:
    1. Utente
    2. Libro
    3. Genere
	
3.1. Utente

    • Id
    • username
    • password
    • email
    • ruolo
    • data di nascita

	Gli utenti saranno distinti per Ruolo fra Admin e User

3.2. Libro

    • Id
    • titolo
    • autore
    • genere
    • anno
    • stato
    • immagine(Opzionale)

	il campo genere sarà associato alla chiave primaria della tabella Genere e gli stati possibili del film saranno Disponibile/Non disponibile

3.3. Genere

    • Id
    • genere

4. Presentazione Biblioteca
            
        In questa sezione verrà descritta la componente di View relativa al catalogo online di una biblioteca.
  

4.1. Pagine Pubbliche
	
    • Landing Page/ Registrazione
    • Login
    • Logout
	
4.1.1 Landing Page/Registrazione

	  La Landing Page presenterà una form di Registrazione ed un link alla pagina di Login.
    Una volta Registrato con successo l’utente verrà reindirizzato alla Home
4.1.2 Login

	La Pagina di login permetterà agli utenti di loggarsi.
	
	Una volta completata con successo la login l’utente verrà reindirizzato home.
		
	
4.2. Pagine Private

    • Home 
    • Catalogo Libri
    • Aggiungi Libri
    • Modifica Libro
    • Aggiungi Genere
    • Gestione Utenti
    • Aggiungi Utente

4.1.1 Home

	  Nella Home Page verranno presentati i primi 5 libri Popolari recuperati da una specifica API

	  https://api.itbook.store

      nello specifico la API da utilizzare sarà la seguente: 

      https://api.itbook.store/1.0/new

	  Saranno presenti inoltre i link alle seguenti pagine:

	Utente:
	
	
    • Catalogo Libri

	Admin:

    • Catalogo Libri
    • Gestione Utenti
4.1.2 Catalogo Libri

	Nella Pagina Catalogo Libri verrà visualizzata una tabella con tutte le info relative ai libri registrati nel sistema

	L’utente comune potrà visualizzare solo i Libri con stato Disponibile
	L’Admin potrà visualizzare tutti i Libri

	(Opzionale) Nel caso gli utenti abbiano più di 45 anni, la lista deli libri sarà ordinata dal meno recente al più recente. In caso contrario dal più recente al meno recente.
	
	L’admin oltre a visualizzare le informazioni legate al libro, potrà modificare o cancellare ogni singolo record tramite apposite CTA all’interno della tabella.


	L’admin visualizzerà in Pagina i Pulsanti:

    • Aggiungi Libro
    • Aggiungi Genere
4.1.3 Aggiungi Libro
	
	Form aggiunta Libro
4.1.4 Modifica Libro
	
	Form Modifica Libro
4.1.5 Aggiungi Genere

	Form aggiunta Genere
4.1.6 Gestione Utenti

	La Pagina Gestione Utenti presenterà una tabella con la lista degli Utenti.
	
	Sarà inoltre presente la CTA Aggiungi Utente
4.1.7 Aggiungi Utente
	            
    Form Aggiunta Utente

4.1.8 Logout

  
    In ogni pagina privata dovrà inoltre essere presente un pulsante di Logout.
    Alla avvenuta Logout l’utente verrà reindirizzato alla Landing Page/Registrazione. 

