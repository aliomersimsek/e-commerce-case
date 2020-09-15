# eCommerce Case Study

## MAIN RULES

### Products:
- Properties of the products: title, price and category.
- While adding the product to the card, if the same product has been added to the card before, the quantity of the product on the card is increased.
- There is no quantity dependency in product deletion process. The product is completely deleted from the card.

### Campaign:
- When the product is added or deleted, the campaigns applied to the card are updated.
- Campaigns are only applied for one category.
- The campaigns depend on the number of products of the category in which they are applied.
- Campaigns are not applied according to the parent category of the product.In other words, parent category campaigns are not applied to products in the child category.
- The campaign is applied all products in the category.

### Coupon:
- Only one coupon can be applied to the card.
- The last applied coupon is valid.
- If the total amount of the card is greater than the "minimum card amount" of the coupon, the coupon can be applied.
- While applying the coupon, "delivery cost" is not added to the amount of the card.
- When applying coupons, the total amount is calculated by including campaign discounts.

### Category:
- Each product has a category.
- The category may have parent category or may not.

### Delivery Rule:
- Delivery rules directly apply to the delivery cost of the card.
- The "getDeliveryCost" method is applied to the cost of delivery.
- There are two types of delivery rule: PRODUCT_COUNT and DELIVERY_COUNT.

### Delivery:
- Deliveries are the addresses where the product will go.
- More than one delivery can be defined to a card.