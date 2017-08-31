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

package org.clang.sema;

import org.clank.support.*;
import static org.clank.support.Native.*;


/// \brief Contains information about the compound statement currently being
/// parsed.
//<editor-fold defaultstate="collapsed" desc="clang::sema::CompoundScopeInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ScopeInfo.h", line = 54,
 FQN="clang::sema::CompoundScopeInfo", NM="_ZN5clang4sema17CompoundScopeInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang4sema17CompoundScopeInfoE")
//</editor-fold>
public class CompoundScopeInfo implements NativePOD<CompoundScopeInfo> {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::sema::CompoundScopeInfo::CompoundScopeInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ScopeInfo.h", line = 56,
   FQN="clang::sema::CompoundScopeInfo::CompoundScopeInfo", NM="_ZN5clang4sema17CompoundScopeInfoC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang4sema17CompoundScopeInfoC1Ev")
  //</editor-fold>
  public CompoundScopeInfo() {
    // : HasEmptyLoopBodies(false) 
    //START JInit
    this.HasEmptyLoopBodies = false;
    //END JInit
  }

  
  /// \brief Whether this compound stamement contains `for' or `while' loops
  /// with empty bodies.
  public boolean HasEmptyLoopBodies;
  
  //<editor-fold defaultstate="collapsed" desc="clang::sema::CompoundScopeInfo::setHasEmptyLoopBodies">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ScopeInfo.h", line = 63,
   FQN="clang::sema::CompoundScopeInfo::setHasEmptyLoopBodies", NM="_ZN5clang4sema17CompoundScopeInfo21setHasEmptyLoopBodiesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang4sema17CompoundScopeInfo21setHasEmptyLoopBodiesEv")
  //</editor-fold>
  public void setHasEmptyLoopBodies() {
    HasEmptyLoopBodies = true;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::sema::CompoundScopeInfo::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ScopeInfo.h", line = 54,
   FQN="clang::sema::CompoundScopeInfo::operator=", NM="_ZN5clang4sema17CompoundScopeInfoaSERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4sema17CompoundScopeInfoaSERKS1_")
  //</editor-fold>
  public /*inline*/ CompoundScopeInfo /*&*/ $assign(final /*const*/ CompoundScopeInfo /*&*/ $Prm0) {
    this.HasEmptyLoopBodies = $Prm0.HasEmptyLoopBodies;
    return /*Deref*/this;
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override public CompoundScopeInfo clone() { 
    return new CompoundScopeInfo().$assign(this); 
  }

  @Override
  public boolean $eq(CompoundScopeInfo other) {
    return other != null && other.HasEmptyLoopBodies == this.HasEmptyLoopBodies;
  }
  
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "HasEmptyLoopBodies=" + HasEmptyLoopBodies; // NOI18N
  }
}
