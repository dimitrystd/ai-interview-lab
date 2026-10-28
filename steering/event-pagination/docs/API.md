# Events API

## GET /events

Returns a page of events, oldest first.

| Parameter | Type | Description |
|-----------|------|-------------|
| `page`    | int  | Zero-based page number. |
| `size`    | int  | Number of events per page. |

Response:

```json
{
  "items": [{ "id": 1, "createdAt": "2024-03-01T09:00:01Z", "type": "order.updated" }],
  "page": 0,
  "size": 10,
  "totalPages": 3
}
```
