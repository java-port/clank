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

package org.clang.format.llvm.yaml.impl;

import org.clank.java.*;
import org.clank.support.*;
import static org.clank.support.Unsigned.*;
import org.clang.format.*;
import org.llvm.support.yaml.*;


// Allows to read vector<FormatStyle> while keeping default values.
// IO.getContext() should contain a pointer to the FormatStyle structure, that
// will be used to get default values for missing keys.
// If the first element has no Language specified, it will be treated as the
// default one for the following elements.
//<editor-fold defaultstate="collapsed" desc="llvm::yaml::DocumentListTraits<vector<FormatStyle, allocator<FormatStyle> > >">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp", line = 389,
 FQN="llvm::yaml::DocumentListTraits<vector<FormatStyle, allocator<FormatStyle> > >", NM="_ZN4llvm4yaml18DocumentListTraitsISt6vectorIN5clang6format11FormatStyleESaIS5_EEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN4llvm4yaml18DocumentListTraitsISt6vectorIN5clang6format11FormatStyleESaIS5_EEEE")
//</editor-fold>
public class/*struct*/ DocumentListTraitsVector$FormatStyle implements DocumentListTraits<FormatStyle, std.vector<FormatStyle>>{
  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::DocumentListTraits<vector<FormatStyle, allocator<FormatStyle> > >::size">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp", line = 390,
   FQN="llvm::yaml::DocumentListTraits<vector<FormatStyle, allocator<FormatStyle> > >::size", NM="_ZN4llvm4yaml18DocumentListTraitsISt6vectorIN5clang6format11FormatStyleESaIS5_EEE4sizeERNS0_2IOERS7_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN4llvm4yaml18DocumentListTraitsISt6vectorIN5clang6format11FormatStyleESaIS5_EEE4sizeERNS0_2IOERS7_")
  //</editor-fold>
  public /*size_t*/int size(final IO /*&*/ $IO, final std.vector<FormatStyle> /*&*/ Seq) {
    return Seq.size();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::yaml::DocumentListTraits<vector<FormatStyle, allocator<FormatStyle> > >::element">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp", line = 393,
   FQN="llvm::yaml::DocumentListTraits<vector<FormatStyle, allocator<FormatStyle> > >::element", NM="_ZN4llvm4yaml18DocumentListTraitsISt6vectorIN5clang6format11FormatStyleESaIS5_EEE7elementERNS0_2IOERS7_j",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.format/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Format/Format.cpp -nm=_ZN4llvm4yaml18DocumentListTraitsISt6vectorIN5clang6format11FormatStyleESaIS5_EEE7elementERNS0_2IOERS7_j")
  //</editor-fold>
  public FormatStyle /*&*/ element(final IO /*&*/ $IO, final std.vector<FormatStyle> /*&*/ Seq, 
         /*size_t*/int Index) {
    if ($greatereq_uint(Index, Seq.size())) {
      FormatStyle Template = null;
      try {
        assert (Index == Seq.size());
        Template/*J*/= new FormatStyle();
        if ($greater_uint(Seq.size(), 0) && Seq.$at(0).Language == FormatStyle.LanguageKind.LK_None) {
          Template.$assign(Seq.$at(0));
        } else {
          Template.$assign(/*Deref*/((/*const*/ FormatStyle /*P*/ )$IO.getContext()));
          Template.Language = FormatStyle.LanguageKind.LK_None;
        }
        Seq.resize(Index + 1, Template);
      } finally {
        if (Template != null) { Template.$destroy(); }
      }
    }
    return Seq.$at(Index);
  }

  @Override
  public MappingTraits<FormatStyle> elementMappingTrait() {
    return new MappingTraitsFormatStyle();
  }

  
  @Override public String toString() {
    return ""; // NOI18N
  }
}
