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

package org.clang.parse.impl;

import static org.clank.support.Native.$AddrOf;
import org.clank.support.*;
import org.clang.ast.*;
import org.clang.sema.*;
import org.clang.parse.*;
import org.clang.parse.impl.*;


/// A class for parsing a field declarator.
//<editor-fold defaultstate="collapsed" desc="clang::ParsingFieldDeclarator">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/RAIIObjectsForParser.h", line = 227,
 FQN="clang::ParsingFieldDeclarator", NM="_ZN5clang22ParsingFieldDeclaratorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang22ParsingFieldDeclaratorE")
//</editor-fold>
public class ParsingFieldDeclarator extends /*public*/ FieldDeclarator implements Destructors.ClassWithDestructor {
  private ParsingDeclRAIIObject ParsingRAII;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ParsingFieldDeclarator::ParsingFieldDeclarator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/RAIIObjectsForParser.h", line = 231,
   FQN="clang::ParsingFieldDeclarator::ParsingFieldDeclarator", NM="_ZN5clang22ParsingFieldDeclaratorC1ERNS_6ParserERKNS_15ParsingDeclSpecE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang22ParsingFieldDeclaratorC1ERNS_6ParserERKNS_15ParsingDeclSpecE")
  //</editor-fold>
  public ParsingFieldDeclarator(Parser /*&*/ P, /*const*/ ParsingDeclSpec /*&*/ DS) {
    // : FieldDeclarator(DS), ParsingRAII(P, &DS.getDelayedDiagnosticPool()) 
    //START JInit
    super(DS);
    this.ParsingRAII = new ParsingDeclRAIIObject(P, $AddrOf(DS.getDelayedDiagnosticPool()));
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ParsingFieldDeclarator::getDeclSpec">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/RAIIObjectsForParser.h", line = 235,
   FQN="clang::ParsingFieldDeclarator::getDeclSpec", NM="_ZNK5clang22ParsingFieldDeclarator11getDeclSpecEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZNK5clang22ParsingFieldDeclarator11getDeclSpecEv")
  //</editor-fold>
  public /*const*/ ParsingDeclSpec /*&*/ getDeclSpec() /*const*/ {
    return ((/*static_cast*//*const*/ ParsingDeclSpec /*&*/ )(D.getDeclSpec()));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ParsingFieldDeclarator::getMutableDeclSpec">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/RAIIObjectsForParser.h", line = 239,
   FQN="clang::ParsingFieldDeclarator::getMutableDeclSpec", NM="_ZNK5clang22ParsingFieldDeclarator18getMutableDeclSpecEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZNK5clang22ParsingFieldDeclarator18getMutableDeclSpecEv")
  //</editor-fold>
  public ParsingDeclSpec /*&*/ getMutableDeclSpec() /*const*/ {
    return ((/*const_cast*/ParsingDeclSpec /*&*/ )(getDeclSpec()));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ParsingFieldDeclarator::complete">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/RAIIObjectsForParser.h", line = 243,
   FQN="clang::ParsingFieldDeclarator::complete", NM="_ZN5clang22ParsingFieldDeclarator8completeEPNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang22ParsingFieldDeclarator8completeEPNS_4DeclE")
  //</editor-fold>
  public void complete(Decl /*P*/ D) {
    ParsingRAII.complete(D);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ParsingFieldDeclarator::~ParsingFieldDeclarator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/RAIIObjectsForParser.h", line = 227,
   FQN="clang::ParsingFieldDeclarator::~ParsingFieldDeclarator", NM="_ZN5clang22ParsingFieldDeclaratorD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp -nm=_ZN5clang22ParsingFieldDeclaratorD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    ParsingRAII.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "ParsingRAII=" + ParsingRAII // NOI18N
              + super.toString(); // NOI18N
  }
}
