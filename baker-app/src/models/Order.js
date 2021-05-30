export class Order {
    constructor(id, orderDate, deliverDate, img, size, notes, pie, user) {
        this.id = id;
        this.orderDate = orderDate;
        this.deliverDate = deliverDate;
        this.img = img;
        this.size = size;
        this.notes = notes;
        this.pie = pie;
        this.user = user;
    }
}