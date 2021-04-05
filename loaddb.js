db = db.getSiblingDB('todolist')

db.users.insert({ id:"1", name:"Evanildo", password: "AAAA", salt:"BBBB", roles: [] })
db.users.insert({ id:"2", name:"Super User", password: "AAAA", salt:"BBBB", roles: ["super"] })
