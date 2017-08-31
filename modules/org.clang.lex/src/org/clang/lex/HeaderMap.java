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

package org.clang.lex;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import org.clang.lex.*;


/// This class represents an Apple concept known as a 'header map'.  To the
/// \#include file resolution process, it basically acts like a directory of
/// symlinks to files.  Its advantages are that it is dense and more efficient
/// to create and process than a directory of symlinks.
//<editor-fold defaultstate="collapsed" desc="clang::HeaderMap">
@Converted(kind = Converted.Kind.MANUAL,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderMap.h", line = 67,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderMap.h", old_line = 34,
 FQN="clang::HeaderMap", NM="_ZN5clang9HeaderMapE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -nm=_ZN5clang9HeaderMapE")
//</editor-fold>
public class HeaderMap extends /*private*/ HeaderMapImpl implements Destructors.ClassWithDestructor {
  
  //<editor-fold defaultstate="collapsed" desc="clang::HeaderMap::HeaderMap">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderMap.h", line = 68,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderMap.h", old_line = 41,
   FQN="clang::HeaderMap::HeaderMap", NM="_ZN5clang9HeaderMapC1ESt10unique_ptrIKN4llvm12MemoryBufferESt14default_deleteIS4_EEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -nm=_ZN5clang9HeaderMapC1ESt10unique_ptrIKN4llvm12MemoryBufferESt14default_deleteIS4_EEb")
  //</editor-fold>
  private HeaderMap(std.unique_ptr</*const*/ MemoryBuffer> File, boolean BSwap) {
    /* : HeaderMapImpl(std::move(File), BSwap)*/ 
    //START JInit
    /*ExprWithCleanups*/super(std.move(File), BSwap);
    //END JInit
  }

/*public:*/
  /// This attempts to load the specified file as a header map.  If it doesn't
  /// look like a HeaderMap, it gives up and returns null.

  //===----------------------------------------------------------------------===//
  // Verification and Construction
  //===----------------------------------------------------------------------===//

  /// HeaderMap::Create - This attempts to load the specified file as a header
  /// map.  If it doesn't look like a HeaderMap, it gives up and returns null.
  /// If it looks like a HeaderMap but is obviously corrupted, it puts a reason
  /// into the string error argument and returns null.
  //<editor-fold defaultstate="collapsed" desc="clang::HeaderMap::Create">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp", line = 51,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp", old_line = 79,
   FQN="clang::HeaderMap::Create", NM="_ZN5clang9HeaderMap6CreateEPKNS_9FileEntryERNS_11FileManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -nm=_ZN5clang9HeaderMap6CreateEPKNS_9FileEntryERNS_11FileManagerE")
  //</editor-fold>
  public static /*const*/ HeaderMap /*P*/ Create(/*const*/ FileEntry /*P*/ FE, FileManager /*&*/ FM) {
    ErrorOr<unique_ptr<MemoryBuffer>> FileBuffer = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // If the file is too small to be a header map, ignore it.
      long/*off_t*/ FileSize = FE.getSize();
      if ($lesseq_ulong_uint(FileSize, /*JAVA*/HMapHeader.$sizeof_HMapHeader())) {
        return null;
      }

      FileBuffer = FM.getBufferForFile(FE);
      if (!FileBuffer.$bool() || !FileBuffer.$star().$bool()) {
        return null; // Unreadable file?
      }
      bool$ref NeedsByteSwap = create_bool$ref();
      if (!checkHeader(FileBuffer.$star().$star(), NeedsByteSwap)) {
        return null;
      }
      return $c$.clean(new HeaderMap($c$.track(new std.unique_ptr</*const*/ MemoryBuffer>(std.move(FileBuffer.$star()))), NeedsByteSwap.$deref()));
    } finally {
      if (FileBuffer != null) { FileBuffer.$destroy(); }
      $c$.$destroy();
    }
  }

  
  /// Check to see if the specified relative filename is located in this
  /// HeaderMap.  If so, open it and return its FileEntry.  If RawPath is not
  /// NULL and the file is found, RawPath will be set to the raw path at which
  /// the file was found in the file system. For example, for a search path
  /// ".." and a filename "../file.h" this would be "../../file.h".

  /// LookupFile - Check to see if the specified relative filename is located in
  /// this HeaderMap.  If so, open it and return its FileEntry.
  //<editor-fold defaultstate="collapsed" desc="clang::HeaderMap::LookupFile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp", line = 199,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp", old_line = 198,
   FQN="clang::HeaderMap::LookupFile", NM="_ZNK5clang9HeaderMap10LookupFileEN4llvm9StringRefERNS_11FileManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -nm=_ZNK5clang9HeaderMap10LookupFileEN4llvm9StringRefERNS_11FileManagerE")
  //</editor-fold>
  public /*const*/ FileEntry /*P*/ LookupFile(StringRef Filename, FileManager /*&*/ FM) /*const*/ {
    
    SmallString/*1024*/ Path/*J*/= new SmallString/*1024*/(1024);
    StringRef Dest = super.lookupFilename(/*NO_COPY*/Filename, Path);
    if (Dest.empty()) {
      return null;
    }
    
    return FM.getFile(/*NO_COPY*/Dest);
  }
  
  
  //JAVA: using HeaderMapImpl::lookupFilename;
  //JAVA: using HeaderMapImpl::getFileName;
  //JAVA: using HeaderMapImpl::dump;
  
  //<editor-fold defaultstate="collapsed" desc="clang::HeaderMap::~HeaderMap">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderMap.h", line = 67,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderMap.h", old_line = 34,
   FQN="clang::HeaderMap::~HeaderMap", NM="_ZN5clang9HeaderMapD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderSearch.cpp -nm=_ZN5clang9HeaderMapD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
