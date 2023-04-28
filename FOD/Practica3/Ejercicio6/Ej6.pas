program Ej6;
type
    prenda = record
        codigo: integer;
        descripcion: string;
        colores: string;
        tipo: string;
        stock: integer;
        precio: real;
    end;

    mae = file of prenda;
    det = file of integer;


procedure procesar (var maestro: mae; var detalle: det);
var
    codBorrar: integer;
    p: prenda;
begin
    reset (maestro);
    Reset (detalle);
    while (not eof(detalle)) do
        begin
            read (detalle, codBorrar);
            p.codigo := -1;
            while (not eof(maestro)) and (p.codigo <> codBorrar) do
                begin
                    read (maestro, p)

                end;
            
            if (p.codigo = codBorrar) then
                begin
                    seek (maestro, FilePos(maestro) - 1);
                    p.stock := p.stock * -1;
                    write (maestro, p);  
                end;
            seek (maestro, 0);

        end;
    
    close (maestro);
    close (detalle);
end;


procedure leerPrenda (var p: prenda);
begin
    writeln ('Codigo: ');
    readln (p.codigo);
    if (p.codigo <> -1) then
      begin
            writeln ('Descripcion: ');
            readln (p.descripcion);
            writeln ('Colores: ');
            readln (p.colores);
            writeln ('Tipo: ');
            readln (p.tipo);
            writeln ('Stock: ');
            readln (p.stock);
            writeln ('Precio: ');
            readln (p.precio);
     
      end;

end;
procedure crearMaestro (var maestro: mae);
var
    p: prenda;
begin
    rewrite (maestro);
    leerPrenda (p);
    while (p.codigo <> -1) do
        begin
            write (maestro, p);
            leerPrenda(p);  
        end;

end;


procedure crearDetalle (var detalle: det);
var
    cod: integer;
begin
    rewrite (detalle);
    writeln ('Ingrese el codigo a borrar');
    readln (cod);
    while (cod <> -1) do
        begin
            write (detalle, cod);
            writeln ('Ingrese el codigo a borrar');
            readln(cod);  
        end;

end;


procedure compactar (var maestro: mae; var aux: mae);
var
    p: prenda;
begin
    reset (maestro);
    rewrite (aux);
  
    while (not eof (maestro)) do
        begin
            read (maestro, p);
            if (p.stock >= 0) then
                write (aux, p);  
        end;  
    
    close (maestro);
    close (aux);

end;





var
    maestro, aux: mae;
    detalle: det;
    p: prenda;
    

begin
    Assign (maestro, 'maestro.dat');
    Assign (detalle, 'detalle.dat');
    Assign (aux, 'compacto.dat');
   // crearMaestro(maestro);
    crearDetalle(detalle);
    procesar(maestro, detalle);
    writeln ('Llegue');
    compactar (maestro, aux);
    
    
    reset(maestro);
    while (not eof(maestro)) do
		begin
			read (maestro, p);
			writeln (p.codigo);
			writeln (p.stock);
		
		end;
    close (maestro);

end.


