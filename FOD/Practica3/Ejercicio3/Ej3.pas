program Ej3;
type
    novela =  record
        codigo: integer;
        genero: string;
        nombre: string;
        duracion: integer;
        director: string;
        precio: real;
    end;

    archivo = file of novela;


procedure leerNovela (var n: novela);
begin
    writeln ('Codigo: ');
    readln (n.codigo);
    if (n.codigo <> -1) then
      begin
            writeln ('genero: ');
            readln (n.genero);
            writeln ('Nombre: ');
            readln (n.nombre);
            writeln ('Duracion: ');
            readln (n.duracion);
            writeln ('Director: ');
            readln (n.director);
             writeln ('Precio:');
             readln (n.precio);
      end;


end;

procedure crearArchivo (var arch: archivo);
var
    n: novela;
begin
    rewrite (arch);
    n.codigo := 0;
    write (arch, n);
    leerNovela(n);
    while (n.codigo <> -1) do
        begin
            write (arch, n);
            leerNovela(n);  
        end;
    
    Close (arch);



end;


procedure Alta (var arch: archivo);
var
    n, encabezado: novela;
    
begin
    reset (arch);
    leerNovela(n);
    read (arch, encabezado);
    if (encabezado.codigo = 0) then
        begin
            seek (arch, FileSize(arch));
            write (arch, n)
        
        end
    else
        begin
            seek (arch, encabezado.codigo * (-1));
            read (arch, encabezado);
            seek (arch, FilePos(arch)-1);
            write (arch, n);
            seek (arch, 0);
            write (arch, encabezado);
        end;

    close (arch);

end;


procedure modificar (var arch: archivo);
var
    n, regN: novela;
    encontre: boolean;

begin
    reset (arch);
    leerNovela(n);
    encontre := false;
    while ((not eof(arch)) and (not encontre)) do
        begin
            read (arch, regN);
            if (regN.codigo = n.codigo) then
                begin
                    encontre := true;  
                end; 

        end;

    if (encontre) then
        begin
            Seek (arch, FilePos(arch) - 1);
            write (arch, n);
        end
    
    else 
        WriteLn('La novela no se encuentra en el archivo');

end;


procedure baja (var arch: archivo);
var
     n, encabezado: novela;

    pos, codigo : integer;
begin
    reset (arch);
    writeln ('Ingrese codigo a borrar');
    readln (codigo);
    read (arch, encabezado);
    n.codigo := encabezado.codigo;
    while (not eof (arch)) and (n.codigo <> codigo ) do
        begin
            read (arch, n);

        end;
    if (n.codigo = codigo) then
        begin
            seek (arch, FilePos(arch) - 1);
            pos := FilePos(arch) * -1;
            n.codigo := encabezado.codigo;
            write (arch, n);
            seek (arch, 0);
            encabezado.codigo := pos;
            write (arch, encabezado);

        end;
  
end;


procedure listarTexto (var arch: archivo; var novelas: text);
var
    n: novela;
begin
    reset (arch);
    Rewrite (novelas);
    writeln ('Llegue');
    while (not eof (arch)) do
        begin
            read (arch, n);
            if (n.codigo > 0) then
                begin
                    with n do
                        writeln (novelas, codigo, genero, nombre , duracion , director, precio);
                end;
        end;
    
    close (arch);
    close (novelas);

end;

procedure menu (var arch: archivo; var novelas: text);
var
    num: integer;
begin

    while (True) do
        begin
      
    
            writeln ('Ingrese 1 para crear archivo');
            writeln ('Ingrese 2 para alta de archivos');
            writeln ('Ingrese 3 para modificar novela');
            writeln ('Ingrese 4 para dar de baja una novela');
            writeln ('Ingrese 5 para exportar a texto de baja una novela');


            readln (num);
            case num of 
                -1: break;
                1: crearArchivo (arch);
                2: Alta (arch);
                3: modificar(arch);
                4: baja (arch);
                5: listarTexto (arch, novelas )
            
            end;
        end;    


end;


var
    arch: archivo;
    novelas: text;

begin
    Assign (arch, 'archivo.dat');
    Assign (novelas, 'novelas.txt');
    menu (arch, novelas);
end.
