package database

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver
import template.sqldelight.db.AppDatabase


actual class DriverFactory {
    actual fun createDriver(): SqlDriver {
        val driver = WebWorkerDriver(
            Worker(
                js("""new URL("@cashapp/sqldelight-sqljs-worker/sqljs.worker.js", import.meta.url)""")
            )
        )
        return driver
    }
}