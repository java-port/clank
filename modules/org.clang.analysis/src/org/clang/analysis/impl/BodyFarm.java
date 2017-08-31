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

package org.clang.analysis.impl;

import org.clank.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.analysis.*;
import static org.clang.ast.java.AstFunctionPointers.*;
import static org.clang.analysis.impl.BodyFarmStatics.*;

//<editor-fold defaultstate="collapsed" desc="clang::BodyFarm">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/BodyFarm.h", line = 32,
 FQN="clang::BodyFarm", NM="_ZN5clang8BodyFarmE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/BodyFarm.cpp -nm=_ZN5clang8BodyFarmE")
//</editor-fold>
public class BodyFarm extends NativeTrace.CreateDestroy$Tracker implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::BodyFarm::BodyFarm">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/BodyFarm.h", line = 34,
   FQN="clang::BodyFarm::BodyFarm", NM="_ZN5clang8BodyFarmC1ERNS_10ASTContextEPNS_12CodeInjectorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/BodyFarm.cpp -nm=_ZN5clang8BodyFarmC1ERNS_10ASTContextEPNS_12CodeInjectorE")
  //</editor-fold>
  public BodyFarm(final ASTContext /*&*/ C, CodeInjector /*P*/ injector) {
    // : C(C), Bodies(), Injector(injector) 
    //START JInit
    this./*&*/C=/*&*/C;
    this.Bodies = new DenseMap</*const*/ Decl /*P*/ , OptionalPtr<Stmt /*P*/ >>(DenseMapInfo$LikePtr.$Info(), new OptionalPtr<Stmt /*P*/ >());
    this.Injector = injector;
    //END JInit
  }

  
  /// Factory method for creating bodies for ordinary functions.
  //<editor-fold defaultstate="collapsed" desc="clang::BodyFarm::getBody">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/BodyFarm.cpp", line = 352,
   FQN="clang::BodyFarm::getBody", NM="_ZN5clang8BodyFarm7getBodyEPKNS_12FunctionDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/BodyFarm.cpp -nm=_ZN5clang8BodyFarm7getBodyEPKNS_12FunctionDeclE")
  //</editor-fold>
  public Stmt /*P*/ getBody(/*const*/ FunctionDecl /*P*/ D) {
    assert checkAlive();
    D = D.getCanonicalDecl$Const();
    
    final OptionalPtr<Stmt /*P*/ > /*&*/ Val = Bodies.$at_T1$RR(D);
    if (Val.hasValue()) {
      return Val.getValue();
    }
    
    Val.$assign_T$RR((Stmt /*P*/ )null);
    if (D.getIdentifier() == null) {
      return null;
    }
    
    StringRef Name = D.getName();
    if (Name.empty()) {
      return null;
    }
    
    ASTContextFunctionDecl2Stmt FF;
    if (Name.startswith(/*STRINGREF_STR*/"OSAtomicCompareAndSwap")
       || Name.startswith(/*STRINGREF_STR*/"objc_atomicCompareAndSwap")) {
      FF = /*FuncRef*/BodyFarmStatics::create_OSAtomicCompareAndSwap;
    } else {
      FF = new StringSwitch<ASTContextFunctionDecl2Stmt>(/*NO_COPY*/Name).
          Case(/*KEEP_STR*/"dispatch_sync", BodyFarmStatics::create_dispatch_sync).
          Case(/*KEEP_STR*/"dispatch_once", BodyFarmStatics::create_dispatch_once).
          Default((ASTContextFunctionDecl2Stmt)null);
    }
    if ((FF != null)) {
      Val.$assign_T$RR(FF.$call(C, D));
    } else if ((Injector != null)) {
      Val.$assign_T$RR(Injector.getBody(D));
    }
    return Val.getValue();
  }

  
  /// Factory method for creating bodies for Objective-C properties.
  //<editor-fold defaultstate="collapsed" desc="clang::BodyFarm::getBody">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/BodyFarm.cpp", line = 484,
   FQN="clang::BodyFarm::getBody", NM="_ZN5clang8BodyFarm7getBodyEPKNS_14ObjCMethodDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/BodyFarm.cpp -nm=_ZN5clang8BodyFarm7getBodyEPKNS_14ObjCMethodDeclE")
  //</editor-fold>
  public Stmt /*P*/ getBody(/*const*/ ObjCMethodDecl /*P*/ D) {
    assert checkAlive();
    // We currently only know how to synthesize property accessors.
    if (!D.isPropertyAccessor()) {
      return null;
    }
    
    D = D.getCanonicalDecl$Const();
    
    final OptionalPtr<Stmt /*P*/ > /*&*/ Val = Bodies.$at_T1$RR(D);
    if (Val.hasValue()) {
      return Val.getValue();
    }
    Val.$assign_T$RR((Stmt /*P*/ )null);
    
    /*const*/ ObjCPropertyDecl /*P*/ Prop = D.findPropertyDecl();
    if (!(Prop != null)) {
      return null;
    }
    
    // For now, we only synthesize getters.
    // Synthesizing setters would cause false negatives in the
    // RetainCountChecker because the method body would bind the parameter
    // to an instance variable, causing it to escape. This would prevent
    // warning in the following common scenario:
    //
    //  id foo = [[NSObject alloc] init];
    //  self.foo = foo; // We should warn that foo leaks here.
    //
    if (D.param_size() != 0) {
      return null;
    }
    
    Val.$assign_T$RR(createObjCPropertyGetter(C, Prop));
    
    return Val.getValue();
  }

/*private:*/
  /*typedef llvm::DenseMap<const Decl *, Optional<Stmt *> > BodyMap*/
//  public final class BodyMap extends DenseMap</*const*/ Decl /*P*/ , Optional<Stmt /*P*/ >>{ };
  
  private final ASTContext /*&*/ C;
  private DenseMap</*const*/ Decl /*P*/ , OptionalPtr<Stmt /*P*/ >> Bodies;
  private CodeInjector /*P*/ Injector;
  //<editor-fold defaultstate="collapsed" desc="clang::BodyFarm::~BodyFarm">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/BodyFarm.h", line = 32,
   FQN="clang::BodyFarm::~BodyFarm", NM="_ZN5clang8BodyFarmD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/BodyFarm.cpp -nm=_ZN5clang8BodyFarmD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    /*<<<default destructor: may be there is another TU where objects are created/destroyed?>>>*/
    super.set$destroyed();
  }


  
  @Override public String toString() {
    return "" + "C=" + "[ASTContext]" // NOI18N
              + ", Bodies=" + Bodies // NOI18N
              + ", Injector=" + Injector; // NOI18N
  }
  
  private boolean checkAlive() {
    if (should$check()) {
      return check$Alive();
    }
    return true;
  }
}
