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


INSERT INTO Niveau (Id_Niveau, Nom_Niveau) VALUES
                                               (1, 'L1'),
                                               (2, 'L2'),
                                               (3, 'L3');


INSERT INTO Groupe (Id_Groupe, Nom_Groupe, Id_Niveau) VALUES
                                                          (1, 'Groupe A', 1),
                                                          (2, 'Groupe B', 1),
                                                          (3, 'Groupe C', 2);

INSERT INTO Etudiant (Id_Etudiant, Nom, Prenom, Email, genre, Id_Groupe) VALUES
                                                                             ('E001', 'Dupont', 'Jean', 'jean.dupont@example.com', 'M', 1),
                                                                             ('E002', 'Martin', 'Alice', 'alice.martin@example.com', 'F', 1),
                                                                             ('E003', 'Durand', 'Pierre', 'pierre.durand@example.com', 'M', 2),
                                                                             ('E004', 'Lefevre', 'Sophie', 'sophie.lefevre@example.com', 'F', 3);

INSERT INTO Professeur (Id, Nom, Prenom, Email) VALUES
                                                    (1, 'Bernard', 'Louis', 'louis.bernard@example.com'),
                                                    (2, 'Moreau', 'Claire', 'claire.moreau@example.com');


INSERT INTO Cours (Id_Cours, Nom_Cours, Description, Id_Prof) VALUES
                                                                  (1, 'PROG2', 'Introduction aux JAVA', 1),
                                                                  (2, 'MGT1', 'Les differentes outils de google workspace', 2);


INSERT INTO Absence (Id_Absence, Date_Absence, Motif, Justification, Id_Etudiant, Id_Cours) VALUES
                                                                                                (1, '2024-09-01', TRUE, 'Maladie', 'E001', 1),
                                                                                                (2, '2024-09-02', FALSE, NULL, 'E002', 2);


INSERT INTO AAbsents (Id_Etudiant, Id_Cours) VALUES
                                                 ('E001', 1),
                                                 ('E002', 2);








