ALTER TABLE orders ADD COLUMN refund_status VARCHAR(16) NOT NULL DEFAULT 'NONE';
CREATE INDEX idx_orders_refund_status ON orders (refund_status);
