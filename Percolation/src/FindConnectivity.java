
public class FindConnectivity
				{
					public int[] blocks;
					public int[] sz;
					
					public FindConnectivity(int numberOfBlocks)
					{
								blocks = new int[numberOfBlocks];
								sz =  new int[numberOfBlocks];
								for (int i = 0; i < blocks.length; i++)
								{
											blocks[i] = i ;
											sz[i] = 1;
								}
					}
					
					public void Union( int p , int q)
					{
								int i = RootOf( p );
								int j = RootOf( q );
								if ( i == j)
								{
										return ;
								}
					
								if( sz[ i ] > sz[ j ] )
								{ 
										
										blocks[j] = i ; 
										sz[i] += sz[j];
								}
								else
								{ 
										blocks[i] = j ; 
										sz[j] += sz[i];
										
								}
								
					}
				
					public int RootOf( int i )
					{
								while( i != blocks[ i ])
								{
										blocks[ i ] = blocks[ blocks [ i ] ];
										i = blocks[ i ] ;
								}
								return i;
					}
					
					public boolean IsConnected(int p, int q )
					{
								if(RootOf(p) == RootOf(q))
								{
										return true;
								}
								return false;
					}
}
