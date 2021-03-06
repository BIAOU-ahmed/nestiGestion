# Projet fil rouge : partie 2
Gestion de stock en JAVA
## Contexte :
L’entreprise Nesti souhaite gérer ses stocks via une application.Pour cela, L’entreprise Nesti vous propose de développer une application en JAVA accompagnée d’une base de données locale ( MySQL ) qui sera accessible uniquement parles administrateurs. 
## Objectif
Le but de cette application est de gérer les articles de type ustensile de cuisine, ainsi que lesingrédients nécessaires aux recettes.L’outil doit être clair et  intuitif. 
## Connexion :
L’application sera accessible après une étape de connexion par un administrateur.
## Ingrédients :
L’application doit permettre de créer, modifier, supprimer et mettre à jour les informationsdes ingrédients.
A partir d’ingrédient, l’administrateur peut choisir de créer un article vendable.
Par exemple :
- un paquet de 1 kg de farineUn ingrédient peut être vendu sous différents conditionnements.
Par exemple :
- une boite de 6 oeufs-une boite de 12 oeufs
## Ustensiles :
L'administrateur peut aussi ajouter des articles de type ustensiles de cuisine, comme :
- cuillère en bois
- fouet
- manic
## Articles :
Les articles peuvent être de type ustensile ou de type ingrédient.
Les frais de livraison varient en fonction du poids de l’article.
Les articles seront achetés à différents fournisseurs. Il se peut qu’un nouveau fournisseurpuisse nous vendre des articles. 
Il faut donc prévoir la possibilité d’ajouter un nouveaufournisseur avec les informations suivantes :
- Nom de l’entreprise et adresse
- Nom et prénom du contact, avec son numéro de téléphoneLes prix varient aussi en fonction du temps.
Commande aux fournisseurs
Prévoir un affichage qui permet de saisir une entrée dans le stock d’un article.

Par exemple :
- Achat de 100 articles ( 1kg de farine ) au fournisseur X.

Et ainsi le stock de cet article sera augmenté de 100 unités.

Un article peut être vendu par plusieurs fournisseurs. 
Le prix d’achat peut varier d’unfournisseur à l’autre.

Le prix d’achat permet de déterminer le prix de vente de l’article .
Le prix de vente est égal au prix d’achat le plus élevé, augmenté de 20%.

Par exemple :
* L’article 1 est un paquet de 1kg de farine.
* Le fournisseur A vend cet article 89 centimes
* Le fournisseur B vend cet article 69 centimesCDA 2020-2021 


Livrables

 - L2-1 Dossier de conception
 - L2-2 Code source via un accès d’un repo public sur github ( par exemple )
 - L2-3 Documentation sur le fonctionnement du code, des algorithmes, recherches techniques réalisées au cours du développement. Cette documentation doit être illustrée par des captures d’écran et clairement expliquer le fonctionnement du code.
 - L2-4 Script de la base de données
 - L2-5 Rapport de réunion écrit et daté attestant des échanges réalisés entre les différents développeurs.
 - L2-6 Manuel d’utilisation pour l’administrateur. Réunissant des captures d’écran de l’application commentée.
 - L2-7 Démonstration de l’application présentant les différentes étapes de création. ( Visioconférences )


## Contraintes :

Utilisation de SWING, Java, Mysql Pour des raisons pédagogiques : on ne tiendra pas compte de la TVA.

Trello : [Lien vers le trello](https://trello.com/b/hEnRxNAP/gestion-darticle-nesti)
## Logiciels utilisés :
[lien star UML](https://staruml.io/)
 [lien looping](https://www.looping-mcd.fr/)

2021©Nesti_Stelare Réalisé par Jessy, Jason et Ahmed
