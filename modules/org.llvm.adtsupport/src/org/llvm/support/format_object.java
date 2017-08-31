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

package org.llvm.support;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.io.*;
import org.llvm.adt.*;


/// These are templated helper classes used by the format function that
/// capture the object to be formated and the format string. When actually
/// printed, this synthesizes the string into a temporary buffer provided and
/// returns whether or not it is big enough.
/*template <typename ... Ts> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::format_object">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Format.h", line = 78,
 FQN="llvm::format_object", NM="_ZN4llvm13format_objectE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN4llvm13format_objectE")
//</editor-fold>
public final class format_object extends /*public*/ format_object_base {
  private std.tuple Vals;
  
  /*template <std::size_t... Is> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::format_object::snprint_tuple">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Format.h", line = 83,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Format.h", old_line = 82,
   FQN="llvm::format_object::snprint_tuple", NM="Tpl__ZNK4llvm13format_object13snprint_tupleEPcjNS_14index_sequenceIJXspT_EEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=Tpl__ZNK4llvm13format_object13snprint_tupleEPcjNS_14index_sequenceIJXspT_EEEE")
  //</editor-fold>
  private int snprint_tuple(char$ptr/*char P*/ Buffer, /*uint*/int BufferSize, 
               index_sequence $Prm2) /*const*/ {
    return snprintf(Buffer, BufferSize, Fmt, Vals.$get());
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::format_object::format_object<Ts...>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Format.h", line = 93,
   FQN="llvm::format_object::format_object<Ts...>", NM="_ZN4llvm13format_objectC1EPKcDpRKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN4llvm13format_objectC1EPKcDpRKT_")
  //</editor-fold>
  public format_object(/*const*/char$ptr/*char P*/ fmt, /*const*/ Object /*&*/ ... vals) {
    // : format_object_base(fmt), Vals(vals...) 
    //START JInit
    /*ParenListExpr*/super(fmt);
    this.Vals = /*ParenListExpr*/new std.tuple(vals);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::format_object::snprint">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Format.h", line = 96,
   FQN="llvm::format_object::snprint", NM="_ZNK4llvm13format_object7snprintEPcj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZNK4llvm13format_object7snprintEPcj")
  //</editor-fold>
  @Override public int snprint(char$ptr/*char P*/ Buffer, /*uint*/int BufferSize) /*const*//* override*/ {
    return snprint_tuple(Buffer, BufferSize, new index_sequence_for());
  }

  
  @Override public String toString() {
    return "" + "Vals=" + Vals // NOI18N
              + super.toString(); // NOI18N
  }
}
