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

package org.clang.frontend.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.lex.*;
import org.clang.serialization.*;
import org.clang.frontend.*;
import org.clang.frontend.impl.*;
import static org.clang.frontend.impl.ASTUnitStatics.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PrecompilePreambleConsumer">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 918,
 FQN="(anonymous namespace)::PrecompilePreambleConsumer", NM="_ZN12_GLOBAL__N_126PrecompilePreambleConsumerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN12_GLOBAL__N_126PrecompilePreambleConsumerE")
//</editor-fold>
public class PrecompilePreambleConsumer extends /*public*/ PCHGenerator implements Destructors.ClassWithDestructor {
  private ASTUnit /*&*/ Unit;
  private uint$ref/*uint &*/ Hash;
  private std.vector<Decl /*P*/ > TopLevelDecls;
  private PrecompilePreambleAction /*P*/ Action;
  private std.unique_ptr<raw_ostream> Out;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PrecompilePreambleConsumer::PrecompilePreambleConsumer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 926,
   FQN="(anonymous namespace)::PrecompilePreambleConsumer::PrecompilePreambleConsumer", NM="_ZN12_GLOBAL__N_126PrecompilePreambleConsumerC1ERN5clang7ASTUnitEPNS_24PrecompilePreambleActionERKNS1_12PreprocessorEN4llvm9StringRefESt10unique_ptrINS9_11raw_ostreamESt14default_deleteISC_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN12_GLOBAL__N_126PrecompilePreambleConsumerC1ERN5clang7ASTUnitEPNS_24PrecompilePreambleActionERKNS1_12PreprocessorEN4llvm9StringRefESt10unique_ptrINS9_11raw_ostreamESt14default_deleteISC_EE")
  //</editor-fold>
  public PrecompilePreambleConsumer(ASTUnit /*&*/ Unit, PrecompilePreambleAction /*P*/ Action, 
      /*const*/ Preprocessor /*&*/ PP, StringRef isysroot, 
      std.unique_ptr<raw_ostream> Out) {
    // : PCHGenerator(PP, "", null, isysroot, std::make_shared<PCHBuffer>(), ArrayRef<IntrusiveRefCntPtr<ModuleFileExtension> >(), /*AllowASTWithErrors=*/ true), Unit(Unit), Hash(Unit.getCurrentTopLevelHashValue()), TopLevelDecls(), Action(Action), Out(std::move(Out)) 
    //START JInit
    /*ExprWithCleanups*/super(PP, new StringRef(/*KEEP_STR*/$EMPTY), (Module /*P*/ )null, new StringRef(isysroot), std.make_shared(new PCHBuffer()), 
        new ArrayRef<IntrusiveRefCntPtr<ModuleFileExtension> >(), 
        true);
    this./*&*/Unit=/*&*/Unit;
    this./*&*/Hash=/*&*/Unit.getCurrentTopLevelHashValue();
    this.TopLevelDecls = new std.vector<Decl /*P*/ >((Decl /*P*/ )null);
    this.Action = Action;
    this.Out = new std.unique_ptr<raw_ostream>(JD$Move.INSTANCE, std.move(Out));
    //END JInit
    Hash.$set(0);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PrecompilePreambleConsumer::HandleTopLevelDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 937,
   FQN="(anonymous namespace)::PrecompilePreambleConsumer::HandleTopLevelDecl", NM="_ZN12_GLOBAL__N_126PrecompilePreambleConsumer18HandleTopLevelDeclEN5clang12DeclGroupRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN12_GLOBAL__N_126PrecompilePreambleConsumer18HandleTopLevelDeclEN5clang12DeclGroupRefE")
  //</editor-fold>
  @Override public boolean HandleTopLevelDecl(DeclGroupRef DG)/* override*/ {
    for (Decl /*P*/ D : DG) {
      // FIXME: Currently ObjC method declarations are incorrectly being
      // reported as top-level declarations, even though their DeclContext
      // is the containing ObjC @interface/@implementation.  This is a
      // fundamental problem in the parser right now.
      if (isa(ObjCMethodDecl.class, D)) {
        continue;
      }
      AddTopLevelDeclarationToHash(D, Hash);
      TopLevelDecls.push_back_T$C$R(D);
    }
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PrecompilePreambleConsumer::HandleTranslationUnit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 951,
   FQN="(anonymous namespace)::PrecompilePreambleConsumer::HandleTranslationUnit", NM="_ZN12_GLOBAL__N_126PrecompilePreambleConsumer21HandleTranslationUnitERN5clang10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN12_GLOBAL__N_126PrecompilePreambleConsumer21HandleTranslationUnitERN5clang10ASTContextE")
  //</editor-fold>
  @Override public void HandleTranslationUnit(ASTContext /*&*/ Ctx)/* override*/ {
    super.HandleTranslationUnit(Ctx);
    if (hasEmittedPCH()) {
      // Write the generated bitstream to "Out".
      Out.$star().$out(getPCH());
      // Make sure it hits disk now.
      Out.$arrow().flush();
      // Free the buffer.
      SmallString Empty/*J*/= new SmallString(0);
      getPCH().$assignMove(std.move(Empty));
      
      // Translate the top-level declarations we captured during
      // parsing into declaration IDs in the precompiled
      // preamble. This will allow us to deserialize those top-level
      // declarations when requested.
      for (Decl /*P*/ D : TopLevelDecls) {
        // Invalid top-level decls may not have been serialized.
        if (D.isInvalidDecl()) {
          continue;
        }
        Unit.addTopLevelDeclFromPreamble(getWriter().getDeclID(D));
      }
      
      Action.setHasEmittedPreamblePCH();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PrecompilePreambleConsumer::~PrecompilePreambleConsumer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 918,
   FQN="(anonymous namespace)::PrecompilePreambleConsumer::~PrecompilePreambleConsumer", NM="_ZN12_GLOBAL__N_126PrecompilePreambleConsumerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN12_GLOBAL__N_126PrecompilePreambleConsumerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    Out.$destroy();
    TopLevelDecls.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "Unit=" + Unit // NOI18N
              + ", Hash=" + Hash // NOI18N
              + ", TopLevelDecls=" + TopLevelDecls // NOI18N
              + ", Action=" + Action // NOI18N
              + ", Out=" + Out // NOI18N
              + super.toString(); // NOI18N
  }
}
