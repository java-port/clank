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

package org.clang.serialization.impl;

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Native.*;
import org.clang.basic.*;
import org.clang.serialization.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclIDComp">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 6565,
 FQN="(anonymous namespace)::DeclIDComp", NM="_ZN12_GLOBAL__N_110DeclIDCompE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN12_GLOBAL__N_110DeclIDCompE")
//</editor-fold>
public class DeclIDComp implements ComparatorLower<Object, Object> {
  private final ASTReader /*&*/ Reader;
  private final ModuleFile /*&*/ Mod;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclIDComp::DeclIDComp">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 6570,
   FQN="(anonymous namespace)::DeclIDComp::DeclIDComp", NM="_ZN12_GLOBAL__N_110DeclIDCompC1ERN5clang9ASTReaderERNS1_13serialization10ModuleFileE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN12_GLOBAL__N_110DeclIDCompC1ERN5clang9ASTReaderERNS1_13serialization10ModuleFileE")
  //</editor-fold>
  public DeclIDComp(final ASTReader /*&*/ Reader, final ModuleFile /*&*/ M) {
    // : Reader(Reader), Mod(M) 
    //START JInit
    this./*&*/Reader=/*&*/Reader;
    this./*&*/Mod=/*&*/M;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclIDComp::operator()">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 6572,
   FQN="(anonymous namespace)::DeclIDComp::operator()", NM="_ZNK12_GLOBAL__N_110DeclIDCompclEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK12_GLOBAL__N_110DeclIDCompclEjj")
  //</editor-fold>
  public boolean $call(/*uint32_t*/int L, /*uint32_t*/int R) /*const*/ {
    SourceLocation LHS = getLocation(L);
    SourceLocation RHS = getLocation(R);
    return Reader.getSourceManager().isBeforeInTranslationUnit(/*NO_COPY*/LHS, /*NO_COPY*/RHS);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclIDComp::operator()">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 6578,
   FQN="(anonymous namespace)::DeclIDComp::operator()", NM="_ZNK12_GLOBAL__N_110DeclIDCompclEN5clang14SourceLocationEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK12_GLOBAL__N_110DeclIDCompclEN5clang14SourceLocationEj")
  //</editor-fold>
  public boolean $call(SourceLocation LHS, /*uint32_t*/int R) /*const*/ {
    SourceLocation RHS = getLocation(R);
    return Reader.getSourceManager().isBeforeInTranslationUnit(/*NO_COPY*/LHS, /*NO_COPY*/RHS);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclIDComp::operator()">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 6583,
   FQN="(anonymous namespace)::DeclIDComp::operator()", NM="_ZNK12_GLOBAL__N_110DeclIDCompclEjN5clang14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK12_GLOBAL__N_110DeclIDCompclEjN5clang14SourceLocationE")
  //</editor-fold>
  public boolean $call(/*uint32_t*/int L, SourceLocation RHS) /*const*/ {
    SourceLocation LHS = getLocation(L);
    return Reader.getSourceManager().isBeforeInTranslationUnit(/*NO_COPY*/LHS, /*NO_COPY*/RHS);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclIDComp::getLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 6588,
   FQN="(anonymous namespace)::DeclIDComp::getLocation", NM="_ZNK12_GLOBAL__N_110DeclIDComp11getLocationEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK12_GLOBAL__N_110DeclIDComp11getLocationEj")
  //</editor-fold>
  public SourceLocation getLocation(/*uint32_t*/int ID) /*const*/ {
    return Reader.getSourceManager().getFileLoc(Reader.getSourceLocationForDeclID(Reader.getGlobalDeclID(Mod, ID)));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclIDComp::DeclIDComp">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 6565,
   FQN="(anonymous namespace)::DeclIDComp::DeclIDComp", NM="_ZN12_GLOBAL__N_110DeclIDCompC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN12_GLOBAL__N_110DeclIDCompC1ERKS0_")
  //</editor-fold>
  public /*inline*/ DeclIDComp(final /*const*/ DeclIDComp /*&*/ $Prm0) {
    // : Reader(.Reader), Mod(.Mod) 
    //START JInit
    this./*&*/Reader=/*&*/$Prm0.Reader;
    this./*&*/Mod=/*&*/$Prm0.Mod;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeclIDComp::DeclIDComp">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 6565,
   FQN="(anonymous namespace)::DeclIDComp::DeclIDComp", NM="_ZN12_GLOBAL__N_110DeclIDCompC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN12_GLOBAL__N_110DeclIDCompC1EOS0_")
  //</editor-fold>
  public /*inline*/ DeclIDComp(JD$Move _dparam, final DeclIDComp /*&&*/$Prm0) {
    // : Reader(static_cast<DeclIDComp &&>().Reader), Mod(static_cast<DeclIDComp &&>().Mod) 
    //START JInit
    this./*&*/Reader=/*&*/$Prm0.Reader;
    this./*&*/Mod=/*&*/$Prm0.Mod;
    //END JInit
  }

  @Override
  public boolean $less(Object one, Object other) {
    if (one instanceof SourceLocation) {
       return $call((SourceLocation)one, (Integer)other);
    } else if (other instanceof SourceLocation) {
       return $call((Integer)one, (SourceLocation)other);
    } else {
       return $call((Integer)one, (Integer)other);
    }
  }

  @Override public String toString() {
    return "" + "Reader=" + Reader // NOI18N
              + ", Mod=" + Mod; // NOI18N
  }
}
