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

package org.llvm.ir;

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Unsigned.*;
import static org.llvm.adt.ADTAliases.*;


/// Call sites that get wrapped by a gc.statepoint (currently only in
/// RewriteStatepointsForGC and potentially in other passes in the future) can
/// have attributes that describe properties of gc.statepoint call they will be
/// eventually be wrapped in.  This struct is used represent such directives.
//<editor-fold defaultstate="collapsed" desc="llvm::StatepointDirectives">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Statepoint.h", line = 432,
 FQN="llvm::StatepointDirectives", NM="_ZN4llvm20StatepointDirectivesE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Statepoint.cpp -nm=_ZN4llvm20StatepointDirectivesE")
//</editor-fold>
public class/*struct*/ StatepointDirectives implements Destructors.ClassWithDestructor {
  public OptionalUInt NumPatchBytes;
  public OptionalULong StatepointID;
  
  public static /*const*/long/*uint64_t*/ DefaultStatepointID = $uint2ulong(0xABCDEF00/*U*/);
  public static /*const*/long/*uint64_t*/ DeoptBundleStatepointID = $uint2ulong(0xABCDEF0F/*U*/);
  //<editor-fold defaultstate="collapsed" desc="llvm::StatepointDirectives::StatepointDirectives">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Statepoint.h", line = 432,
   FQN="llvm::StatepointDirectives::StatepointDirectives", NM="_ZN4llvm20StatepointDirectivesC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Statepoint.cpp -nm=_ZN4llvm20StatepointDirectivesC1EOS0_")
  //</editor-fold>
  public /*inline*/ StatepointDirectives(JD$Move _dparam, final StatepointDirectives /*&&*/$Prm0) {
    // : NumPatchBytes(static_cast<StatepointDirectives &&>().NumPatchBytes), StatepointID(static_cast<StatepointDirectives &&>().StatepointID) 
    //START JInit
    this.NumPatchBytes = new OptionalUInt(JD$Move.INSTANCE, $Prm0.NumPatchBytes);
    this.StatepointID = new OptionalULong(JD$Move.INSTANCE, $Prm0.StatepointID);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::StatepointDirectives::~StatepointDirectives">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Statepoint.h", line = 432,
   FQN="llvm::StatepointDirectives::~StatepointDirectives", NM="_ZN4llvm20StatepointDirectivesD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Statepoint.cpp -nm=_ZN4llvm20StatepointDirectivesD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    StatepointID.$destroy();
    NumPatchBytes.$destroy();
    //END JDestroy
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::StatepointDirectives::StatepointDirectives">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Statepoint.h", line = 432,
   FQN="llvm::StatepointDirectives::StatepointDirectives", NM="_ZN4llvm20StatepointDirectivesC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Statepoint.cpp -nm=_ZN4llvm20StatepointDirectivesC1Ev")
  //</editor-fold>
  public /*inline*/ StatepointDirectives() {
    // : NumPatchBytes(), StatepointID() 
    //START JInit
    this.NumPatchBytes = new OptionalUInt();
    this.StatepointID = new OptionalULong();
    //END JInit
  }

  
  @Override public String toString() {
    return "" + "NumPatchBytes=" + NumPatchBytes // NOI18N
              + ", StatepointID=" + StatepointID; // NOI18N
  }
}
