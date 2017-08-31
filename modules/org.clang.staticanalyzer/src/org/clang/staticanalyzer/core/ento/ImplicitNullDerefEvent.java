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

package org.clang.staticanalyzer.core.ento;

import org.clank.support.*;
import org.clang.staticanalyzer.core.bugreporter.ento.*;
import org.clang.staticanalyzer.core.ento.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;


/// \brief We dereferenced a location that may be null.
//<editor-fold defaultstate="collapsed" desc="clang::ento::ImplicitNullDerefEvent">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/Checker.h", line = 541,
 FQN="clang::ento::ImplicitNullDerefEvent", NM="_ZN5clang4ento22ImplicitNullDerefEventE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NSErrorChecker.cpp -nm=_ZN5clang4ento22ImplicitNullDerefEventE")
//</editor-fold>
public class/*struct*/ ImplicitNullDerefEvent {
  public SVal Location;
  public boolean IsLoad;
  public ExplodedNode /*P*/ SinkNode;
  public BugReporter /*P*/ BR;
  // When true, the dereference is in the source code directly. When false, the
  // dereference might happen later (for example pointer passed to a parameter
  // that is marked with nonnull attribute.)
  public boolean IsDirectDereference;
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ImplicitNullDerefEvent::ImplicitNullDerefEvent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/Checker.h", line = 541,
   FQN="clang::ento::ImplicitNullDerefEvent::ImplicitNullDerefEvent", NM="_ZN5clang4ento22ImplicitNullDerefEventC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NSErrorChecker.cpp -nm=_ZN5clang4ento22ImplicitNullDerefEventC1ERKS1_")
  //</editor-fold>
  public /*inline*/ ImplicitNullDerefEvent(final /*const*/ ImplicitNullDerefEvent /*&*/ $Prm0) {
    // : Location(.Location), IsLoad(.IsLoad), SinkNode(.SinkNode), BR(.BR), IsDirectDereference(.IsDirectDereference) 
    //START JInit
    this.Location = new SVal($Prm0.Location);
    this.IsLoad = $Prm0.IsLoad;
    this.SinkNode = $Prm0.SinkNode;
    this.BR = $Prm0.BR;
    this.IsDirectDereference = $Prm0.IsDirectDereference;
    //END JInit
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public ImplicitNullDerefEvent(SVal Location, boolean IsLoad, ExplodedNode SinkNode, BugReporter BR, boolean IsDirectDereference) {
    this.Location = Location;
    this.IsLoad = IsLoad;
    this.SinkNode = SinkNode;
    this.BR = BR;
    this.IsDirectDereference = IsDirectDereference;
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Location=" + Location // NOI18N
              + ", IsLoad=" + IsLoad // NOI18N
              + ", SinkNode=" + SinkNode // NOI18N
              + ", BR=" + BR // NOI18N
              + ", IsDirectDereference=" + IsDirectDereference; // NOI18N
  }
}
