CREATE database examfinal;
\c examfinal;

CREATE TABLE Niveau (
                        Id_Niveau INT PRIMARY KEY,
                        Nom_Niveau CHAR(5) NOT NULL
);


CREATE TABLE Groupe (
                        Id_Groupe INT PRIMARY KEY,
                        Nom_Groupe VARCHAR(50) NOT NULL,
                        Id_Niveau INT,
                        FOREIGN KEY (Id_Niveau) REFERENCES Niveau(Id_Niveau)
);


CREATE TABLE Etudiant (
                          Id_Etudiant VARCHAR(50) PRIMARY KEY,
                          Nom VARCHAR(100) NOT NULL,
                          Prenom VARCHAR(100) NOT NULL,
                          Email VARCHAR(150),
                          genre CHAR(1),
                          Id_Groupe INT,
                          FOREIGN KEY (Id_Groupe) REFERENCES Groupe(Id_Groupe)
);


CREATE TABLE Professeur (
                            Id INT PRIMARY KEY,
                            Nom VARCHAR(50) NOT NULL,
                            Prenom VARCHAR(50) NOT NULL,
                            Email VARCHAR(50)
);


CREATE TABLE Cours (
                       Id_Cours INT PRIMARY KEY,
                       Nom_Cours VARCHAR(50) NOT NULL,
                       Description TEXT,
                       Id_Prof INT,
                       FOREIGN KEY (Id_Prof) REFERENCES Professeur(Id)
);


CREATE TABLE Absence (
                         Id_Absence INT PRIMARY KEY,
                         Date_Absence DATE NOT NULL,
                         Motif BOOL,
                         Justification TEXT,
                         Id_Etudiant VARCHAR(50),
                         Id_Cours INT,
                         FOREIGN KEY (Id_Etudiant) REFERENCES Etudiant(Id_Etudiant),
                         FOREIGN KEY (Id_Cours) REFERENCES Cours(Id_Cours)
);


CREATE TABLE ACours (
                        Id_Cours INT,
                        Id_Prof INT,
                        PRIMARY KEY (Id_Cours, Id_Prof),
                        FOREIGN KEY (Id_Cours) REFERENCES Cours(Id_Cours),
                        FOREIGN KEY (Id_Prof) REFERENCES Professeur(Id)
);


CREATE TABLE AAbsents (
                          Id_Etudiant VARCHAR(50),
                          Id_Cours INT,
                          PRIMARY KEY (Id_Etudiant, Id_Cours),
                          FOREIGN KEY (Id_Etudiant) REFERENCES Etudiant(Id_Etudiant),
                          FOREIGN KEY (Id_Cours) REFERENCES Cours(Id_Cours)
);



