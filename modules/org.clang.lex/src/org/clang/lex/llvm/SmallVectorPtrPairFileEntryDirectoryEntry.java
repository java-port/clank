/**
 * This file was converted to Java from the original LLVM source file. The original
 * source file follows the LLVM Release License, outlined below.
 * 
 * ==============================================================================
 * LLVM Release License
 * ==============================================================================
 * University of Illinois/NCSA
 * Open Source License
 * 
 * Copyright (c) 2003-2017 University of Illinois at Urbana-Champaign.
 * All rights reserved.
 * 
 * Developed by:
 * 
 *     LLVM Team
 * 
 *     University of Illinois at Urbana-Champaign
 * 
 *     http://llvm.org
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal with
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is furnished to do
 * so, subject to the following conditions:
 * 
 *     * Redistributions of source code must retain the above copyright notice,
 *       this list of conditions and the following disclaimers.
 * 
 *     * Redistributions in binary form must reproduce the above copyright notice
 *       this list of conditions and the following disclaimers in the
 *       documentation and/or other materials provided with the distribution.
 * 
 *     * Neither the names of the LLVM Team, University of Illinois at
 *       Urbana-Champaign, nor the names of its contributors may be used to
 *       endorse or promote products derived from this Software without specific
 *       prior written permission.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.  IN NO EVENT SHALL THE
 * CONTRIBUTORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS WITH THE
 * SOFTWARE.
 * 
 * ==============================================================================
 * Copyrights and Licenses for Third Party Software Distributed with LLVM:
 * ==============================================================================
 * The LLVM software contains code written by third parties.  Such software will
 * have its own individual LICENSE.TXT file in the directory in which it appears.
 * This file will describe the copyrights, license, and restrictions which apply
 * to that code.
 * 
 * The disclaimer of warranty in the University of Illinois Open Source License
 * applies to all code in the LLVM Distribution, and nothing in any of the
 * other licenses gives permission to use the names of the LLVM Team or the
 * University of Illinois to endorse or promote products derived from this
 * Software.
 * 
 * The following pieces of software have additional or alternate copyrights,
 * licenses, and/or restrictions:
 * 
 * Program             Directory
 * -------             ---------
 * Autoconf            llvm/autoconf
 *                     llvm/projects/ModuleMaker/autoconf
 * Google Test         llvm/utils/unittest/googletest
 * OpenBSD regex       llvm/lib/Support/{reg*, COPYRIGHT.regex}
 * pyyaml tests        llvm/test/YAMLParser/{*.data, LICENSE.TXT}
 * ARM contributions   llvm/lib/Target/ARM/LICENSE.TXT
 * md5 contributions   llvm/lib/Support/MD5.cpp llvm/include/llvm/Support/MD5.h
 */
package org.clang.lex.llvm;

import org.clang.basic.DirectoryEntry;
import org.clang.basic.FileEntry;
import org.clank.java.*;
import org.clank.support.Converted;
import org.clank.support.*;
import static org.clank.support.NativePointer.*;
import org.llvm.adt.aliases.SmallVector;

/**
 * SmallVectorImpl for std.pair<const FileEntry * , const DirectoryEntry * >
 */
//<editor-fold defaultstate="collapsed" desc="template">
@Converted(kind = Converted.Kind.DUMMY, source = "${SPUTNIK}/modules/org.llvm.adtsupport/src/org/llvm/adt/aliases/templates/SmallVectorImpl.tpl")
//</editor-fold>
public final class SmallVectorPtrPairFileEntryDirectoryEntry implements NativeType.SizeofCapable {
  // constant to be used as defaultValue in other collections.
  // tihs instance is cloned, but have not be modified
  public static final SmallVectorPtrPairFileEntryDirectoryEntry DEFAULT = new SmallVectorPtrPairFileEntryDirectoryEntry(0, null);
  
  private FileEntry[]      arrayFileEntry;
  private DirectoryEntry[] arrayDirectoryEntry;
  
  private int end;
  
  public SmallVectorPtrPairFileEntryDirectoryEntry(SmallVector<std.pair</*const*/ FileEntry /*P*/ , /*const*/ DirectoryEntry /*P*/ >> other) {
    int capacity = other.capacity();
    this.end = other.size();
    this.arrayFileEntry = new FileEntry[capacity];
    this.arrayDirectoryEntry = new DirectoryEntry[capacity];
    for (int i = 0; i < end; i++) {
      std.pair<FileEntry, DirectoryEntry> p = other.$at(i);
      this.arrayFileEntry[i] = p.first;
      this.arrayDirectoryEntry[i] = p.second;
    }
  }
  
  public SmallVectorPtrPairFileEntryDirectoryEntry(int capacity, std.pair</*const*/ FileEntry /*P*/ , /*const*/ DirectoryEntry /*P*/ > defaultValue) {
    this.arrayFileEntry = new FileEntry[capacity];
    this.arrayDirectoryEntry = new DirectoryEntry[capacity];
    this.end = 0;
    assert defaultValue == null;
  }

  public final void clear() {
//    this.destroy_range(0, this.size());
    this.setEnd(0);
  }
  
  public final FileEntry first$at(int idx) {
    return arrayFileEntry[idx];
  }

  public final DirectoryEntry second$at(int idx) {
    return arrayDirectoryEntry[idx];
  }
  
  public final boolean empty() {
    return this.size() == 0;
  }
  
  public final void $destroy() {
    destroy_range(0, end);
    end = 0;
  }
  
  public final void push_back(/*std.pair<*//*const*/ FileEntry /*P*/ first, /*const*/ DirectoryEntry /*P*/ second) {
    if (this.size() >= this.capacity()) {
      this.grow();
    }
    arrayFileEntry[end] = first;
    arrayDirectoryEntry[end] = second;
    end++;
  }     

  public final FileEntry first$front() {
    return arrayFileEntry[0];
  }    

  public final DirectoryEntry second$front() {
    return arrayDirectoryEntry[0];
  }    
  
  public final /*size_t*/int size() /*const*/ {
    return end;
  }

  public final /*size_t*/int max_size() /*const*/ {
    return Integer.MAX_VALUE; // TODO 
  }

  /// capacity - Return the total number of elements in the currently allocated
  /// buffer.
  public final /*size_t*/int capacity() /*const*/ {
    return arrayFileEntry.length;
  }

  @Override public final /*size_t*/int $sizeof() {
    return capacity_in_bytes();
  }

  public final /*size_t*/int capacity_in_bytes() {
    return 2 * arrayFileEntry.length * NativeType.BYTES_IN_JAVA_OBJECT_REF;
  }


  /// Set the array size to \p N, which the current array must have enough
  /// capacity for.
  ///
  /// This does not construct or destroy any elements in the vector.
  ///
  /// Clients can use this in conjunction with capacity() to write past the end
  /// of the buffer when they know that more elements are available, and only
  /// update the size later. This avoids the cost of value initializing elements
  /// which will only be overwritten.
  public final void set_size(int N) {
    assert(N <= this.capacity());
    this.setEnd(N);
  }  
  
  private void destroy_range(int from, int to) {
     for (int i = from; i < to; i++) { 
       arrayFileEntry[i] = null;
       arrayDirectoryEntry[i] = null;
     }
  }

  private void grow(int newSize) {    
    FileEntry[] oldFileEntryArray = arrayFileEntry;
    arrayFileEntry = new FileEntry[newSize];
    copy$Object(oldFileEntryArray, 0, arrayFileEntry, 0, oldFileEntryArray.length);
    DirectoryEntry[] oldDirectoryEntryArray = arrayDirectoryEntry;
    arrayDirectoryEntry = new DirectoryEntry[newSize];
    copy$Object(oldDirectoryEntryArray, 0, arrayDirectoryEntry, 0, oldDirectoryEntryArray.length);
  }

  private void grow() {
    int capacity = capacity();
    if (capacity == 0) {
      arrayFileEntry = new FileEntry[8];
      arrayDirectoryEntry = new DirectoryEntry[8];
    } else {
      this.grow(capacity * 2);
    }
  }  
  
  private void setEnd(int to) {
    end = to;
  }  

  @Override
  public String toString() {
    if (this.end == 0) {
      return "<EMPTY>";
    }
    StringBuilder out = new StringBuilder("\nSmallVectorPtrPairFileEntryDirectoryEntry{\nend = " + this.end + '\n');
    String fmt = "%" + (int)Math.ceil(Math.log10(this.end+1)) + "d";
    for (int i = 0; i < this.end; i++) {
      FileEntry file = arrayFileEntry[i];
      DirectoryEntry dir = arrayDirectoryEntry[i];
      out.append("[").append(String.format(fmt, i)).append("]{");
      out.append(file).append(";").append(dir).append("}\n");
    }
    out.append("}SmallVectorPtrPairFileEntryDirectoryEntry}\n");
    return out.toString();
  }
}
