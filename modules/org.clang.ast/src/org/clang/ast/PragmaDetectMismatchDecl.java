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
import org.clank.support.aliases.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import org.clank.java.std;
import static org.clank.support.Native.$toConst;


/// \brief Represents a `#pragma detect_mismatch` line. Always a child of
/// TranslationUnitDecl.
//<editor-fold defaultstate="collapsed" desc="clang::PragmaDetectMismatchDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 143,
 FQN="clang::PragmaDetectMismatchDecl", NM="_ZN5clang24PragmaDetectMismatchDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang24PragmaDetectMismatchDeclE")
//</editor-fold>
public final class PragmaDetectMismatchDecl extends /*public*/ Decl implements /*private*/ TrailingObjects$Char<PragmaDetectMismatchDecl>, Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="clang::PragmaDetectMismatchDecl::anchor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 3946,
   FQN="clang::PragmaDetectMismatchDecl::anchor", NM="_ZN5clang24PragmaDetectMismatchDecl6anchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang24PragmaDetectMismatchDecl6anchorEv")
  //</editor-fold>
  protected/*private*/ void anchor() {
  }

  
  /*friend*/public /*size_t*/int ValueStart;
  
  /*friend  TrailingObjects<PragmaDetectMismatchDecl, char>*/
  /*friend  class ASTDeclReader*/
  /*friend  class ASTDeclWriter*/
  
  //<editor-fold defaultstate="collapsed" desc="clang::PragmaDetectMismatchDecl::PragmaDetectMismatchDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 154,
   FQN="clang::PragmaDetectMismatchDecl::PragmaDetectMismatchDecl", NM="_ZN5clang24PragmaDetectMismatchDeclC1EPNS_19TranslationUnitDeclENS_14SourceLocationEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang24PragmaDetectMismatchDeclC1EPNS_19TranslationUnitDeclENS_14SourceLocationEj")
  //</editor-fold>
  private PragmaDetectMismatchDecl(TranslationUnitDecl /*P*/ TU, SourceLocation Loc, 
      /*size_t*/int ValueStart) {
    // : Decl(PragmaDetectMismatch, TU, Loc), TrailingObjects<PragmaDetectMismatchDecl, char>(), ValueStart(ValueStart) 
    //START JInit
    super(Kind.PragmaDetectMismatch, TU, new SourceLocation(Loc));
    $TrailingObjects();
    this.ValueStart = ValueStart;
    //END JInit
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::PragmaDetectMismatchDecl::Create">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*Alloc*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 3948,
   FQN="clang::PragmaDetectMismatchDecl::Create", NM="_ZN5clang24PragmaDetectMismatchDecl6CreateERKNS_10ASTContextEPNS_19TranslationUnitDeclENS_14SourceLocationEN4llvm9StringRefES8_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang24PragmaDetectMismatchDecl6CreateERKNS_10ASTContextEPNS_19TranslationUnitDeclENS_14SourceLocationEN4llvm9StringRefES8_")
  //</editor-fold>
  public static PragmaDetectMismatchDecl /*P*/ Create(final /*const*/ ASTContext /*&*/ C, TranslationUnitDecl /*P*/ DC, 
        SourceLocation Loc, StringRef Name, 
        StringRef Value) {
    /*size_t*/int ValueStart = Name.size() + 1;
    char$ptr arg$chars = $toConst(create_char$ptr(new$char(ValueStart + Value.size() + 1)));
    final int Extra = TrailingObjects$Char.additionalSizeToAlloc$Same(byte.class, ValueStart + Value.size() + 1);
    assert Extra == 1 : "we use only one slot for char$ptr " + Extra;
    PragmaDetectMismatchDecl /*P*/ PDMD = /*NEW_EXPR [Decl::new]*//*new (C, DC, additionalSizeToAlloc<charbyte>(ValueStart + Value.size() + 1))*/Decl.$new(C, DC, Extra, (type$ptr<?> Mem)->{
        return new PragmaDetectMismatchDecl(DC, new SourceLocation(Loc), ValueStart);
     },
        new std.pairIntPtr<>(Extra, ()->arg$chars) // for char *
    );
    assert PDMD.getTrailingObjects(/*char byte.class*/) == arg$chars;
    memcpy(PDMD.getTrailingObjects(/*char byte.class*/), Name.data(), Name.size());
    PDMD.getTrailingObjects(/*char byte.class*/).$set(Name.size(), $$TERM);
    memcpy(PDMD.getTrailingObjects(/*char byte.class*/).$add(ValueStart), Value.data(), 
        Value.size());
    PDMD.getTrailingObjects(/*char byte.class*/).$set(ValueStart + Value.size(), $$TERM);
    return PDMD;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PragmaDetectMismatchDecl::CreateDeserialized">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*Alloc*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 3964,
   FQN="clang::PragmaDetectMismatchDecl::CreateDeserialized", NM="_ZN5clang24PragmaDetectMismatchDecl18CreateDeserializedERNS_10ASTContextEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang24PragmaDetectMismatchDecl18CreateDeserializedERNS_10ASTContextEjj")
  //</editor-fold>
  public static PragmaDetectMismatchDecl /*P*/ CreateDeserialized(final ASTContext /*&*/ C, /*uint*/int ID, 
                    /*uint*/int NameValueSize) {
    char$ptr arg$chars = $toConst(create_char$ptr(new$char(NameValueSize + 1)));
    final int Extra = TrailingObjects$Char.additionalSizeToAlloc$Same(byte.class, NameValueSize + 1);
    assert Extra == 1 : "we use only one slot for char$ptr";
    PragmaDetectMismatchDecl PDMD = /*NEW_EXPR [Decl::new]*//*new (C, ID, additionalSizeToAlloc<charbyte>(NameValueSize + 1))*/ Decl.$new(C, ID, Extra, (type$ptr<?> Mem)->{
        return new PragmaDetectMismatchDecl((TranslationUnitDecl /*P*/ )null, new SourceLocation(), 0);
     },
        new std.pairIntPtr<>(Extra, ()->arg$chars) // for char *
    );
    assert PDMD.getTrailingObjects(/*char byte.class*/) == arg$chars;
    return PDMD;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::PragmaDetectMismatchDecl::getName">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 166,
   FQN="clang::PragmaDetectMismatchDecl::getName", NM="_ZNK5clang24PragmaDetectMismatchDecl7getNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang24PragmaDetectMismatchDecl7getNameEv")
  //</editor-fold>
  public StringRef getName() /*const*/ {
    return new StringRef(getTrailingObjects$Const/*<char>*/());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PragmaDetectMismatchDecl::getValue">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 167,
   FQN="clang::PragmaDetectMismatchDecl::getValue", NM="_ZNK5clang24PragmaDetectMismatchDecl8getValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZNK5clang24PragmaDetectMismatchDecl8getValueEv")
  //</editor-fold>
  public StringRef getValue() /*const*/ {
    return new StringRef(getTrailingObjects$Const/*<char>*/().$add(ValueStart));
  }

  
  // Implement isa/cast/dyncast/etc.
  //<editor-fold defaultstate="collapsed" desc="clang::PragmaDetectMismatchDecl::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 170,
   FQN="clang::PragmaDetectMismatchDecl::classof", NM="_ZN5clang24PragmaDetectMismatchDecl7classofEPKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang24PragmaDetectMismatchDecl7classofEPKNS_4DeclE")
  //</editor-fold>
  public static boolean classof(/*const*/ Decl /*P*/ D) {
    return classofKind(D.getKind());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PragmaDetectMismatchDecl::classofKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 171,
   FQN="clang::PragmaDetectMismatchDecl::classofKind", NM="_ZN5clang24PragmaDetectMismatchDecl11classofKindENS_4Decl4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang24PragmaDetectMismatchDecl11classofKindENS_4Decl4KindE")
  //</editor-fold>
  public static boolean classofKind(Kind K) {
    return K == Kind.PragmaDetectMismatch;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PragmaDetectMismatchDecl::~PragmaDetectMismatchDecl">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 143,
   FQN="clang::PragmaDetectMismatchDecl::~PragmaDetectMismatchDecl", NM="_ZN5clang24PragmaDetectMismatchDeclD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang24PragmaDetectMismatchDeclD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
    TrailingObjects$Char.super.$destroy$TrailingObjects();
  }

  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  @Override public char$ptr getTrailingObjects() {
    // char$ptr is in the cell after $this, see PragmaDetectMismatchDecl::Create*
    return (char$ptr)super.$This$Ptr().$add(1).$star();
  }
  
  @Override public String toString() {
    return "" + "ValueStart=" + ValueStart // NOI18N
              + super.toString(); // NOI18N
  }
}
