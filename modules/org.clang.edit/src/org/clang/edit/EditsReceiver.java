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

package org.clang.edit;

import org.clank.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;

//<editor-fold defaultstate="collapsed" desc="clang::edit::EditsReceiver">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Edit/EditsReceiver.h", line = 21,
 FQN="clang::edit::EditsReceiver", NM="_ZN5clang4edit13EditsReceiverE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/EditedSource.cpp -nm=_ZN5clang4edit13EditsReceiverE")
//</editor-fold>
public abstract class EditsReceiver implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::edit::EditsReceiver::~EditsReceiver">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Edit/EditsReceiver.h", line = 23,
   FQN="clang::edit::EditsReceiver::~EditsReceiver", NM="_ZN5clang4edit13EditsReceiverD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/EditedSource.cpp -nm=_ZN5clang4edit13EditsReceiverD0Ev")
  //</editor-fold>
  public /*virtual*/ void $destroy() {
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::edit::EditsReceiver::insert">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Edit/EditsReceiver.h", line = 25,
   FQN="clang::edit::EditsReceiver::insert", NM="_ZN5clang4edit13EditsReceiver6insertENS_14SourceLocationEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/EditedSource.cpp -nm=_ZN5clang4edit13EditsReceiver6insertENS_14SourceLocationEN4llvm9StringRefE")
  //</editor-fold>
  public abstract /*virtual*/ void insert(SourceLocation loc, StringRef text)/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="clang::edit::EditsReceiver::replace">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Edit/EditsReceiver.h", line = 26,
   FQN="clang::edit::EditsReceiver::replace", NM="_ZN5clang4edit13EditsReceiver7replaceENS_15CharSourceRangeEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/EditedSource.cpp -nm=_ZN5clang4edit13EditsReceiver7replaceENS_15CharSourceRangeEN4llvm9StringRefE")
  //</editor-fold>
  public abstract /*virtual*/ void replace(CharSourceRange range, StringRef text)/* = 0*/;

  /// \brief By default it calls replace with an empty string.
  //<editor-fold defaultstate="collapsed" desc="clang::edit::EditsReceiver::remove">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Edit/EditedSource.cpp", line = 22,
   FQN="clang::edit::EditsReceiver::remove", NM="_ZN5clang4edit13EditsReceiver6removeENS_15CharSourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Edit/EditedSource.cpp -nm=_ZN5clang4edit13EditsReceiver6removeENS_15CharSourceRangeE")
  //</editor-fold>
  public void remove(CharSourceRange range) {
    replace(new CharSourceRange(range), new StringRef());
  }


  //<editor-fold defaultstate="collapsed" desc="clang::edit::EditsReceiver::EditsReceiver">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Edit/EditsReceiver.h", line = 21,
   FQN="clang::edit::EditsReceiver::EditsReceiver", NM="_ZN5clang4edit13EditsReceiverC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.edit/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN5clang4edit13EditsReceiverC1Ev")
  //</editor-fold>
  public /*inline*/ EditsReceiver() {
  }

  
  @Override public String toString() {
    return ""; // NOI18N
  }
}
