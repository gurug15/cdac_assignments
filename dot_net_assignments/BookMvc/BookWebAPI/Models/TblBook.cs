using System;
using System.Collections.Generic;
using BookWebAPI.Models;
using Microsoft.AspNetCore.Http.HttpResults;
using Microsoft.AspNetCore.OpenApi;
using Microsoft.EntityFrameworkCore;

namespace BookWebAPI.Models;

public partial class TblBook
{
    public int BookId { get; set; }

    public string BookName { get; set; } = null!;

    public string BookAuthor { get; set; } = null!;

    public string BookPrice { get; set; } = null!;
}


public static class TblBookEndpoints
{
	public static void MapTblBookEndpoints (this IEndpointRouteBuilder routes)
    {
        var group = routes.MapGroup("/api/TblBook").WithTags(nameof(TblBook));

        group.MapGet("/", async (BooksDbContext db) =>
        {
            return await db.TblBooks.ToListAsync();
        })
        .WithName("GetAllTblBooks")
        .WithOpenApi();

        group.MapGet("/{id}", async Task<Results<Ok<TblBook>, NotFound>> (int bookid, BooksDbContext db) =>
        {
            return await db.TblBooks.AsNoTracking()
                .FirstOrDefaultAsync(model => model.BookId == bookid)
                is TblBook model
                    ? TypedResults.Ok(model)
                    : TypedResults.NotFound();
        })
        .WithName("GetTblBookById")
        .WithOpenApi();

        group.MapPut("/{id}", async Task<Results<Ok, NotFound>> (int bookid, TblBook tblBook, BooksDbContext db) =>
        {
            var affected = await db.TblBooks
                .Where(model => model.BookId == bookid)
                .ExecuteUpdateAsync(setters => setters
                  .SetProperty(m => m.BookId, tblBook.BookId)
                  .SetProperty(m => m.BookName, tblBook.BookName)
                  .SetProperty(m => m.BookAuthor, tblBook.BookAuthor)
                  .SetProperty(m => m.BookPrice, tblBook.BookPrice)
                  );
            return affected == 1 ? TypedResults.Ok() : TypedResults.NotFound();
        })
        .WithName("UpdateTblBook")
        .WithOpenApi();

        group.MapPost("/", async (TblBook tblBook, BooksDbContext db) =>
        {
            db.TblBooks.Add(tblBook);
            await db.SaveChangesAsync();
            return TypedResults.Created($"/api/TblBook/{tblBook.BookId}",tblBook);
        })
        .WithName("CreateTblBook")
        .WithOpenApi();

        group.MapDelete("/{id}", async Task<Results<Ok, NotFound>> (int bookid, BooksDbContext db) =>
        {
            var affected = await db.TblBooks
                .Where(model => model.BookId == bookid)
                .ExecuteDeleteAsync();
            return affected == 1 ? TypedResults.Ok() : TypedResults.NotFound();
        })
        .WithName("DeleteTblBook")
        .WithOpenApi();
    }
}