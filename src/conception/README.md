# Projet fil rouge : partie 2
## Conception
Le concept de l'application est de permettre à un administrateur de gérer des articles de type ustensile de cuisine ou de type ingrédient. Il aura aussi la possibilité de gêner des fournisseurs.

Après concertation entre nous, nous avons decider de commencer par l'use Case.

## Use Case
![matrice de dépendance](/conception/images/useCase.png)
## Docummentations Use Case
#### Cases :
- Manage Account : permet d'ajouter, de mettre à jour ou de supprimer les administrateurs.
- Manage Provider :  permet d'ajouter, de mettre à jour ou de supprimer les fournisseurs.
- Manage Article : permet d'ajouter, de mettre à jour ou de supprimer les articles.

#### Acteurs :
- Administrateur : Personne qui gère l'application, les commande, les fournisseurs, les produits et les articles, mais il n'a pas accès à la gestion des administrateurs.
- SuperAdmin : À les même droit qu'un administrateur et peut en plus les gérer.


Aprés le UseCase on à basculé sur le diagramme de class .

## Diagramme de classe
![Diagramme de class](/src/conception/images)

## Dictionnaire de données
![dictionnaire de donnée](/images/logo.png)
## Matrice de dépendance fonctionnelle
![matrice de dépendance](/images/logo.png)





