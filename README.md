Spring Bootshop

### Client
[https://github.com/andresnogales/bookshop-client ](https://github.com/andresnogales/bookshop-client)

### Endpoints

#### Sign-Up

```
POST /api/authentication/sign-up HTTP/1.1
Host: localhost:8080
Content-Type: application/json

{
    "name": "user",
    "username": "user",
    "password": "user"
}
```

#### Sign-In

```
POST /api/authentication/sign-in HTTP/1.1
Host: localhost:8080
Content-Type: application/json

{
    "username": "user",
    "password": "user"
}
```

#### Make-admin

```
PUT /api/internal/make-admin/admin HTTP/1.1
Host: localhost:8080
Authorization: Bearer SecretInternalKey
```

#### Save Book

```
GET /api/book/3 HTTP/1.1
Host: localhost:8080
Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsInJvbGVzIjoiUk9MRV9BRE1JTiIsInVzZXJJZCI6MiwiZXhwIjoxNjQwNzYxMDE4fQ.Q1dOM2mG428MfXICD5ilWh8KNX6Iyxz0Hj6eXDBM4EvIK26rsjCwAGE8uGQ2kDszp54KvuHfwRbsp_klQ9vq8A
Content-Type: application/json
Content-Length: 1298

{
    "author": {
        "biography": "Según la tradición, el poeta griego Homero (ss. IX-VIII a. de C., aproximadamente) fue el autor de la Ilíada y de la Odisea, por lo que es considerado uno de los escritores más influyentes de todos los tiempos. Algunos críticos modernos, sin embargo, mantienen que Homero no fue el auténtico creador de estas obras, sino que se limitó a compilar y unificar una gran cantidad de relatos orales que él mismo recitaba. Sea como fuere, ambos poemas se convirtieron en la base de la educación y cultura griega en la época clásica, así como de la literatura occidental moderna.",
        "fullName": "Homero",
        "id": 1,
        "picture": "https://planetadelibrosar0.cdnstatics.com/usuaris/libros/fotos/70/m_libros/69641_portada_odisea_homero_201505211318.jpg"
    },
    "category": {
        "genre": {
            "id": 1,
            "name": "Poesía",
            "thematic": {
                "id": 1,
                "name": "Literatura"
            }
        },
        "id": 1,
        "name": "Poesía épica"
    },
    "id": 3,
    "createTime": "2021-12-01T11:34:40.283396",
    "description": "La Ilíada, compuesta en el siglo VIII a.C., narra una leyenda micénica situada en el siglo XIII a.C., una edad heroica dominada por los aspectos militares, el individualismo desenfrenado y la persecución de la riqueza y la gloria. La Ilíada cuenta un episodio de la epopeya de la rica y estratégica ciudad de Troya, o Ilión. Es el poema de la cólera de Aquiles, hijo de mortal y diosa y el más destacado de los combatientes griegos, en su afán de heroicidad y sus ansias de venganza.",
    "editorial": "Gredos",
    "format": "Papel",
    "isbn": "123456789",
    "picture": "https://planetadelibrosar8.cdnstatics.com/usuaris/libros/fotos/118/m_libros/portada_iliada_homero_201903010942.jpg",
    "price": 3955.0,
    "title": "La Ilíada"
}

```

#### Delete Book

```
DELETE /api/book/2 HTTP/1.1
Host: localhost:8080
Authorization: Bearer ...admin
```

#### Get All Books

```
GET /api/book HTTP/1.1
Host: localhost:8080
```

#### Save Purchase

```
POST /api/purchase-history HTTP/1.1
Host: localhost:8080
Authorization: Bearer ...user or admin
Content-Type: application/json
Content-Length: 53

{
    "userId": 3,
    "bookId": 1,
    "price": 10
}
```

#### Get User Purchases

```
GET /api/purchase-history HTTP/1.1
Host: localhost:8080
Authorization: Bearer ...user or admin
```
