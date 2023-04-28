program ej7;
type
    especie = record
        codigo: Longint;
        nombre: string;
        familia: string;
        descripcion: string;
        zona: string;
    end;

    mae = file of especie;



procedure leerEspecie (var e: especie);
begin
    writeln ('Codigo: ');
    readln(e.codigo);
    writeln ('Nombre: ');
    readln(e.nombre);
    writeln ('Familia: ');
    readln(e.familia);
    writeln ('Descripcion: ');
    readln(e.descripcion);
    writeln ('Zona: ');
    readln(e.zona);
end;


procedure crearMaestro (var maestro: mae);
var
    e: especie;
begin
    Rewrite(maestro);
    leerEspecie(e);
    while (e.codigo <> 500000) do
        begin
            Write(maestro, e);
            leerEspecie(e);
        end;
end;




procedure eliminar (var maestro: mae);
var
    cantEliminados : integer;
    codEliminar : LongInt;
    e: especie;
begin
    Reset(maestro);

    writeln ('Ingrese codigo a eliminar');
    readln (codEliminar);
    while(codEliminar <> 500000) do
        begin
            e.codigo := 500000;
            while (not eof(maestro) and (e.codigo <> codEliminar)) do
                begin
                    read (maestro, e);     
                end;

            if (e.codigo = codEliminar) then
                begin
                    e.codigo := e.codigo * (-1);
                    seek (maestro, FilePos(maestro)-1);
                    Write(maestro, e);
                end;
            
            Seek(maestro, 0);

            writeln ('Ingrese codigo a eliminar');
            readln (codEliminar);
            
        end;
    close (maestro)
    
end;


procedure compactar (var maestro: mae);
var
    pos, cantEliminados : integer;
    e: especie;
begin

    reset (maestro);
    cantEliminados := 0;
    while (not eof(maestro)) do
        begin
            read (maestro, e);
            if (e.codigo < 0) then
                begin
                    cantEliminados := cantEliminados + 1;
                    pos := FilePos(maestro) - 1;  
                    seek (maestro, FileSize(maestro) - (cantEliminados));
                    read (maestro, e);
                    seek (maestro, pos);
                    write (maestro,e);

                end;
            

        end;
    seek (maestro, FileSize(maestro) - (cantEliminados));
    Truncate(maestro);

end;


procedure imprimirEspecie (e: especie);
begin
    writeln ('Codigo: ', e.codigo, ', Nombre especie: ', e.nombre, ', familia: ', e.familia, ' descripcion: ', e.descripcion, ' zona: ', e.zona);
end;
procedure imprimirMaestro(var maestro: mae);
var
    e: especie;
begin
    reset (maestro);
    while (not eof(maestro)) do
        begin
            read (maestro, e); 
            imprimirEspecie (e); 

        end;
end;
var 
    maestro: mae;

begin
	assign (maestro, 'maestro.dat');
    crearMaestro (maestro);
    eliminar (maestro);
    compactar(maestro);
    imprimirMaestro (maestro);
end.
