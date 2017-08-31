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

package org.clang.ast;

import org.clank.support.*;


//===----------------------------------------------------------------------===//
// Kinds of Template Parameters
//===----------------------------------------------------------------------===//

/// \brief Defines the position of a template parameter within a template
/// parameter list.
///
/// Because template parameter can be listed
/// sequentially for out-of-line template members, each template parameter is
/// given a Depth - the nesting of template parameter scopes - and a Position -
/// the occurrence within the parameter list.
/// This class is inheritedly privately by different kinds of template
/// parameters and is not part of the Decl hierarchy. Just a facility.
//<editor-fold defaultstate="collapsed" desc="clang::TemplateParmPosition">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1005,
 FQN="clang::TemplateParmPosition", NM="_ZN5clang20TemplateParmPositionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang20TemplateParmPositionE")
//</editor-fold>
public interface/*class*/ TemplateParmPosition {
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateParmPosition::TemplateParmPosition">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1006,
   FQN="clang::TemplateParmPosition::TemplateParmPosition", NM="_ZN5clang20TemplateParmPositionC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang20TemplateParmPositionC1Ev")
  //</editor-fold>
  public/*private*/ default/*interface*/ TemplateParmPosition$Fields $TemplateParmPosition(/*uint*/int D, /*uint*/int P) {
    return new TemplateParmPosition$Fields(D,P);
  }

/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateParmPosition::TemplateParmPosition">
  @Converted(kind = Converted.Kind.MANUAL_ADDED/*wrapper to keep fields*/)
  public static final class TemplateParmPosition$Fields {
    // FIXME: These probably don't need to be ints. int:5 for depth, int:8 for
    // position? Maybe?
    public/*protected*/ /*uint*/int Depth;
    public/*protected*/ /*uint*/int Position;
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1009,
     FQN="clang::TemplateParmPosition::TemplateParmPosition", NM="_ZN5clang20TemplateParmPositionC1Ejj",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang20TemplateParmPositionC1Ejj")
    //</editor-fold>
    public/*protected*/ /*interface*/ TemplateParmPosition$Fields(/*uint*/int D, /*uint*/int P) {
      // : Depth(D), Position(P) 
      //START JInit
      this.Depth = D;
      this.Position = P;
      //END JInit
    }
  
    @Override public String toString() {
      return "" + "Depth=" + Depth // NOI18N
                + ", Position=" + Position; // NOI18N
    }
  }
  @Converted(kind = Converted.Kind.MANUAL_ADDED/*wrapper to keep fields*/)
  public abstract TemplateParmPosition$Fields $TemplateParmPosition$Fields();
  /*public:*/
  /// Get the nesting depth of the template parameter.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateParmPosition::getDepth">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1020,
   FQN="clang::TemplateParmPosition::getDepth", NM="_ZNK5clang20TemplateParmPosition8getDepthEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang20TemplateParmPosition8getDepthEv")
  //</editor-fold>
  public default/*interface*/ /*uint*/int getDepth() /*const*/ {
    return $TemplateParmPosition$Fields().Depth;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateParmPosition::setDepth">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1021,
   FQN="clang::TemplateParmPosition::setDepth", NM="_ZN5clang20TemplateParmPosition8setDepthEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang20TemplateParmPosition8setDepthEj")
  //</editor-fold>
  public default/*interface*/ void setDepth(/*uint*/int D) {
    $TemplateParmPosition$Fields().Depth = D;
  }

  
  /// Get the position of the template parameter within its parameter list.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateParmPosition::getPosition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1024,
   FQN="clang::TemplateParmPosition::getPosition", NM="_ZNK5clang20TemplateParmPosition11getPositionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang20TemplateParmPosition11getPositionEv")
  //</editor-fold>
  public default/*interface*/ /*uint*/int getPosition() /*const*/ {
    return $TemplateParmPosition$Fields().Position;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateParmPosition::setPosition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1025,
   FQN="clang::TemplateParmPosition::setPosition", NM="_ZN5clang20TemplateParmPosition11setPositionEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang20TemplateParmPosition11setPositionEj")
  //</editor-fold>
  public default/*interface*/ void setPosition(/*uint*/int P) {
    $TemplateParmPosition$Fields().Position = P;
  }

  
  /// Get the index of the template parameter within its parameter list.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateParmPosition::getIndex">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 1028,
   FQN="clang::TemplateParmPosition::getIndex", NM="_ZNK5clang20TemplateParmPosition8getIndexEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang20TemplateParmPosition8getIndexEv")
  //</editor-fold>
  public default/*interface*/ /*uint*/int getIndex() /*const*/ {
    return $TemplateParmPosition$Fields().Position;
  }
  
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  public default void $destroy$TemplateParmPosition(){
  }
}
