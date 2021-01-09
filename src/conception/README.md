# Projet fil rouge : partie 2
## Conception
Le concept de l'application est de permettre � un administrateur de g�rer des articles de type ustensile de cuisine ou de type ingr�dient. Il aura aussi la possibilit� de g�ner des fournisseurs.

Apr�s concertation entre nous, nous avons decider de commencer par l'use Case.

## Use Case
![matrice de d�pendance](/conception/images/useCase.png)
## Docummentations Use Case
#### Cases :
- Manage Account : permet d'ajouter, de mettre � jour ou de supprimer les administrateurs.
- Manage Provider :  permet d'ajouter, de mettre � jour ou de supprimer les fournisseurs.
- Manage Article : permet d'ajouter, de mettre � jour ou de supprimer les articles.

#### Acteurs :
- Administrateur : Personne qui g�re l'application, les commande, les fournisseurs, les produits et les articles, mais il n'a pas acc�s � la gestion des administrateurs.
- SuperAdmin : � les m�me droit qu'un administrateur et peut en plus les g�rer.


Apr�s le UseCase on � bascul� sur le diagramme de class .

## Diagramme de classe
![Diagramme de class](/src/conception/images)

## Dictionnaire de donn�es
![dictionnaire de donn�e](/images/logo.png)
## Matrice de d�pendance fonctionnelle
![matrice de d�pendance](/images/logo.png)





