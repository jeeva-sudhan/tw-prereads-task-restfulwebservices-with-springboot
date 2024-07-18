CREATE TABLE usercart (
  user_id BIGINT,
  cart_item_id BIGINT,
  FOREIGN KEY(user_id) REFERENCES users(id),
  FOREIGN KEY(cart_item_id) REFERENCES cartitem(cart_item_id)
);
