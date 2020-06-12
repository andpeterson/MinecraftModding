export type UUID = string | null
export type Timestamp = Number;

export type Task = {
  group: string
  description: string
  icon: string
}

export type Tasks = {
  [id: string]: Task
}

export type Notification = {
  uuid: UUID
  timestamp: Timestamp
  type: string
  message: string
  response: string
}