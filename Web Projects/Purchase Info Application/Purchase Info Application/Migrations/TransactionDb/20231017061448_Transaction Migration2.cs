using Microsoft.EntityFrameworkCore.Migrations;

#nullable disable

namespace Purchase_Info_Application.Migrations.TransactionDb
{
    /// <inheritdoc />
    public partial class TransactionMigration2 : Migration
    {
        /// <inheritdoc />
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.RenameColumn(
                name: "itemId",
                table: "Transactions",
                newName: "ItemId");
        }

        /// <inheritdoc />
        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.RenameColumn(
                name: "ItemId",
                table: "Transactions",
                newName: "itemId");
        }
    }
}
