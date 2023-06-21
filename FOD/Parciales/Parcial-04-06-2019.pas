program parcial;
type
    venta = record
        cod_farmaco : integer;
        nombre : string;
        fecha: string;
        cantidad_vendida : integer;
        forma_pago : string;
    end;

    archivoVentas = file of venta;
    vectorArchivos = array[1..30] of archivoVentas;
    vectorRegistros = array[1..30] of venta;

procedure leer (var arch: archivoVentas; var v: venta)
begin
    if (not eof(arch)) then
        begin
            read(arch, v);  
        end
    else 
        v.cod_farmaco := 32000;
end;


procedure minimo (var vector: vectorArchivos; var registros: vectorRegistros; var min: venta);
var
    i, minIndice : integer;
begin
    min.cod_farmaco := 32000;
    for i := 1 to 30 do
        begin
            if (registros[i].cod_farmaco < min.cod_farmaco) then
                begin
                    min.cod_farmaco = registros[i].cod_farmaco;
                    minIndice = i;  
                end;
        end;
    
    leer(arch[minIndice], registros[minIndice]);

end;
procedure procesoA (var vector: vectorArchivos;);
var
    cantCodigo: integer;
    codActual : integer;
    min: venta
    registros : vectorRegistros;
    max: integer;
    maxCodigo: integer;
begin
    max := -1;
    for i := 1 to 30 do
        begin
            reset(vector[i]);  
            read(vector[i], registros[i])    
        end;
    minimo(vector, registros, min);
    while (min.cod_farmaco <> 32000) do
        begin
            codActual := min.cod_farmaco;
            cantActual := 0;
            while (codActual = min.cod_farmaco) do
                begin
                    cantActual := cantActual + min.cantidad_vendida;
                    minimo(vector, registros, min);  
                end;
            
            if (cantActual > max) then
                begin
                    max := cantActual;
                    maxCodigo := codActual;
                end;
        end;
    
    WriteLn(maxCodigo);
    
end;