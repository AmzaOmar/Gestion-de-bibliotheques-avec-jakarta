CREATE TABLE Abonne (
    numero_abonnement INT PRIMARY KEY,
    prenoms VARCHAR(100),
    nom VARCHAR(100),
    statut VARCHAR(50),
    institution VARCHAR(100),
    adresse_email VARCHAR(100)
);

CREATE TABLE Livre (
    identifiant INT PRIMARY KEY,
    titre VARCHAR(200),
    auteurs VARCHAR(200),
    annee_publication INT,
    domaine VARCHAR(100),
    niveau VARCHAR(50)
);

CREATE TABLE Exemplaire (
    numero INT PRIMARY KEY,
    reference_livre INT,
    FOREIGN KEY (reference_livre) REFERENCES Livre(identifiant)
);

CREATE TABLE Bibliothecaire (
    identifiant INT PRIMARY KEY,
    prenoms VARCHAR(100),
    nom VARCHAR(100),
    date_recrutement DATE,
    adresse VARCHAR(200),
    adresse_email VARCHAR(100)
);
CREATE TABLE emprunt (
    id_emprunt INT PRIMARY KEY AUTO_INCREMENT,
    numero_abonnement INT,
    id_exemplaire INT,
    date_emprunt DATE,
    date_retour_prevue DATE,
    date_retour DATE,
    FOREIGN KEY (numero_abonnement) REFERENCES abonne(numero_abonnement),
    FOREIGN KEY (id_exemplaire) REFERENCES exemplaire(numero)
);

