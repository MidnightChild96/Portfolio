using Microsoft.EntityFrameworkCore.Migrations;

#nullable disable

namespace Purchase_Info_Application.Migrations
{
    /// <inheritdoc />
    public partial class users3 : Migration
    {
        /// <inheritdoc />
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.RenameColumn(
                name: "Id",
                table: "Users",
                newName: "UserId");

            migrationBuilder.RenameIndex(
                name: "IX_Users_Id",
                table: "Users",
                newName: "IX_Users_UserId");
        }

        /// <inheritdoc />
        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.RenameColumn(
                name: "UserId",
                table: "Users",
                newName: "Id");

            migrationBuilder.RenameIndex(
                name: "IX_Users_UserId",
                table: "Users",
                newName: "IX_Users_Id");
        }
    }
}
