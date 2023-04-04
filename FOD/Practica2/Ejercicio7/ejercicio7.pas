program ejercicio7;
const
    VALORALTO = 32000;
type
    regMae = record
        codigo: integer;
        nombre: string;
        precio: real;
        stockA: integer;
        stockM: integer;
    end;

    regDet= record
        codigo: integer;
        cant: integer;
    end;

    maestro = file of regMae;
    detalle = file of regDet;


procedure leer (var archD: detalle; var r: regDet);
begin
    if (not eof(archD)) then
        begin
            read (archD, r);

        end
    else
        r.codigo := VALORALTO;
    

end;



procedure procesar (var archM: maestro; var archD: detalle);
var
    regD, actual: regDet;
    regM: regMae;

begin
    reset (archM);
    reset (archD);
    leer (archD, regD);
    read (archM, regM);

    while (regD.codigo <> VALORALTO) do 
        begin
            actual.codigo := regD.codigo;
            actual.cant := 0;
            while (actual.codigo = regD.codigo) do  
                begin
                    actual.cant := actual.cant + regD.cant;
                    leer (archD, regD);

                end;
            
            while (regM.codigo <> actual.codigo) do 
                begin
                    read (archM, regM);


                end;
            
            regM.stockA := regM.stockA - actual.cant;
            seek (archM, filePos (archM) - 1);
            write(archM, regM);
            

        end;

    close (archD);
    close(archM);
end;


procedure exportar (var archM: maestro; var stockMinimo: text);
var
    regM: regMae;
begin
    reset (archM);
    rewrite (stockMinimo);
    while (not eof(archM)) do   
        begin
            read (archM, regM);
            if (regM.stockA < regM.stockM) then
                begin
                    with regM do
                        writeln (stockMinimo, 'Codigo: ', codigo, ' stockMinimo',  stockM, ' stockActual: ', stockA,  ' nombre:', nombre);

                end;

        end;
    close (archM);
    close(stockMinimo);

end;
procedure menu (var archM: maestro; var archD: detalle; var stockMinimo: text);
var 
    num: integer;
begin
    writeln ('Opcion1: actualizar maestro');
    writeln ('Opcion2: exportar a texto');
    readln (num);
    case num of 
        1: procesar(archM, archD);
        2: exportar(archM, stockMinimo);
    end;



end;


var
    archM: maestro;
    archD: detalle;
    stockMinimo: text;

begin
    assign (archM, 'maestro.dat');
    assign (archD, 'detalle.dat');
    assign (stockMinimo, 'stockM.txt');
    menu (archM, archD, stockMinimo);



end.
