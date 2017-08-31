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

package org.clang.driver;

import org.clank.support.*;
import org.llvm.adt.aliases.*;
import org.clang.driver.*;
;

//<editor-fold defaultstate="collapsed" desc="clang::driver::LipoJobAction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Action.h", line = 420,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Action.h", old_line = 267,
 FQN="clang::driver::LipoJobAction", NM="_ZN5clang6driver13LipoJobActionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp -nm=_ZN5clang6driver13LipoJobActionE")
//</editor-fold>
public class LipoJobAction extends /*public*/ JobAction implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="clang::driver::LipoJobAction::anchor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp", line = 314,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp", old_line = 144,
   FQN="clang::driver::LipoJobAction::anchor", NM="_ZN5clang6driver13LipoJobAction6anchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp -nm=_ZN5clang6driver13LipoJobAction6anchorEv")
  //</editor-fold>
  @Override protected/*private*/ void anchor()/* override*/ {
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::driver::LipoJobAction::LipoJobAction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp", line = 316,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp", old_line = 146,
   FQN="clang::driver::LipoJobAction::LipoJobAction", NM="_ZN5clang6driver13LipoJobActionC1ERN4llvm11SmallVectorIPNS0_6ActionELj3EEENS0_5types2IDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp -nm=_ZN5clang6driver13LipoJobActionC1ERN4llvm11SmallVectorIPNS0_6ActionELj3EEENS0_5types2IDE")
  //</editor-fold>
  public LipoJobAction(/*ActionList*/SmallVector<Action /*P*/>/*&*/ Inputs, types.ID Type) {
    /* : JobAction(LipoJobClass, Inputs, Type)*/ 
    //START JInit
    super(ActionClass.LipoJobClass, Inputs, Type);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::LipoJobAction::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Action.h", line = 425,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Action.h", old_line = 272,
   FQN="clang::driver::LipoJobAction::classof", NM="_ZN5clang6driver13LipoJobAction7classofEPKNS0_6ActionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp -nm=_ZN5clang6driver13LipoJobAction7classofEPKNS0_6ActionE")
  //</editor-fold>
  public static boolean classof(/*const*/Action/*P*/ A) {
    return A.getKind() == ActionClass.LipoJobClass;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::LipoJobAction::~LipoJobAction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Action.h", line = 420,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Driver/Action.h", old_line = 267,
   FQN="clang::driver::LipoJobAction::~LipoJobAction", NM="_ZN5clang6driver13LipoJobActionD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp -nm=_ZN5clang6driver13LipoJobActionD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
