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
package org.clang.codegen.CodeGen.impl;

import org.clang.ast.*;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.JD$Move;
import static org.clank.support.Unsigned.*;
import org.llvm.ir.*;


//<editor-fold defaultstate="collapsed" desc="static type CodeGenModule_NestedClasses">
@Converted(kind = Converted.Kind.MANUAL,
 NM="org.clang.codegen.CodeGen.impl.CodeGenModule_NestedClasses",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDeclCXX.cpp ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule14DeferredGlobalE;_ZN5clang7CodeGen13CodeGenModule21GlobalInitPriorityCmpE;_ZN5clang7CodeGen13CodeGenModule8StructorE;_ZN5clang7CodeGen13CodeGenModuleE_Unnamed_struct4; -static-type=CodeGenModule_NestedClasses -package=org.clang.codegen.CodeGen.impl")
//</editor-fold>
public abstract class CodeGenModule_NestedClasses extends CodeGenTypeCache {
private final /*split clang::CodeGen::CodeGenModule*/ CodeGenModule $this() { return (CodeGenModule)this; }

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::Structor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.h", line = 251,
 FQN="clang::CodeGen::CodeGenModule::Structor", NM="_ZN5clang7CodeGen13CodeGenModule8StructorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDeclCXX.cpp -nm=_ZN5clang7CodeGen13CodeGenModule8StructorE")
//</editor-fold>
public static class/*struct*/ Structor implements NativeCloneable<Structor> {
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::Structor::Structor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.h", line = 252,
   FQN="clang::CodeGen::CodeGenModule::Structor::Structor", NM="_ZN5clang7CodeGen13CodeGenModule8StructorC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDeclCXX.cpp -nm=_ZN5clang7CodeGen13CodeGenModule8StructorC1Ev")
  //</editor-fold>
  public Structor() {
    // : Priority(0), Initializer(null), AssociatedData(null) 
    //START JInit
    this.Priority = 0;
    this.Initializer = null;
    this.AssociatedData = null;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::Structor::Structor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.h", line = 253,
   FQN="clang::CodeGen::CodeGenModule::Structor::Structor", NM="_ZN5clang7CodeGen13CodeGenModule8StructorC1EiPN4llvm8ConstantES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDeclCXX.cpp -nm=_ZN5clang7CodeGen13CodeGenModule8StructorC1EiPN4llvm8ConstantES5_")
  //</editor-fold>
  public Structor(int Priority, Constant /*P*/ Initializer, 
      Constant /*P*/ AssociatedData) {
    // : Priority(Priority), Initializer(Initializer), AssociatedData(AssociatedData) 
    //START JInit
    this.Priority = Priority;
    this.Initializer = Initializer;
    this.AssociatedData = AssociatedData;
    //END JInit
  }

  public int Priority;
  public Constant /*P*/ Initializer;
  public Constant /*P*/ AssociatedData;

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::Structor::Structor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.h", line = 251,
   FQN="clang::CodeGen::CodeGenModule::Structor::Structor", NM="_ZN5clang7CodeGen13CodeGenModule8StructorC1EOS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModule8StructorC1EOS2_")
  //</editor-fold>
  public /*inline*/ Structor(JD$Move _dparam, final Structor /*&&*/$Prm0) {
    // : Priority(static_cast<Structor &&>().Priority), Initializer(static_cast<Structor &&>().Initializer), AssociatedData(static_cast<Structor &&>().AssociatedData) 
    //START JInit
    this.Priority = $Prm0.Priority;
    this.Initializer = $Prm0.Initializer;
    this.AssociatedData = $Prm0.AssociatedData;
    //END JInit
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override
  public Structor clone() { 
    return new Structor(this.Priority, this.Initializer, this.AssociatedData);
  }
  

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Priority=" + Priority // NOI18N
              + ", Initializer=" + Initializer // NOI18N
              + ", AssociatedData=" + AssociatedData; // NOI18N
  }
}

/// This is a list of deferred decls which we have seen that *are* actually
/// referenced. These get code generated when the module is done.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::DeferredGlobal">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.h", line = 312,
 FQN="clang::CodeGen::CodeGenModule::DeferredGlobal", NM="_ZN5clang7CodeGen13CodeGenModule14DeferredGlobalE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDeclCXX.cpp -nm=_ZN5clang7CodeGen13CodeGenModule14DeferredGlobalE")
//</editor-fold>
protected/*private*/ static class/*struct*/ DeferredGlobal implements NativeCloneable<DeferredGlobal>, Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::DeferredGlobal::DeferredGlobal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.h", line = 313,
   FQN="clang::CodeGen::CodeGenModule::DeferredGlobal::DeferredGlobal", NM="_ZN5clang7CodeGen13CodeGenModule14DeferredGlobalC1EPN4llvm11GlobalValueENS_10GlobalDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDeclCXX.cpp -nm=_ZN5clang7CodeGen13CodeGenModule14DeferredGlobalC1EPN4llvm11GlobalValueENS_10GlobalDeclE")
  //</editor-fold>
  public DeferredGlobal(GlobalValue /*P*/ GV, GlobalDecl GD) {
    // : GV(GV), GD(GD) 
    //START JInit
    this.GV = new TrackingVH<GlobalValue>(GlobalValue.class, GV);
    this.GD = new GlobalDecl(GD);
    //END JInit
  }

  public TrackingVH<GlobalValue> GV;
  public GlobalDecl GD;
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::DeferredGlobal::DeferredGlobal">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.h", line = 312,
   FQN="clang::CodeGen::CodeGenModule::DeferredGlobal::DeferredGlobal", NM="_ZN5clang7CodeGen13CodeGenModule14DeferredGlobalC1ERKS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDeclCXX.cpp -nm=_ZN5clang7CodeGen13CodeGenModule14DeferredGlobalC1ERKS2_")
  //</editor-fold>
  public /*inline*/ DeferredGlobal(final /*const*/ DeferredGlobal /*&*/ $Prm0) {
    // : GV(.GV), GD(.GD) 
    //START JInit
    this.GV = new TrackingVH<GlobalValue>(GlobalValue.class, $Prm0.GV.$star());
    this.GD = new GlobalDecl($Prm0.GD);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::DeferredGlobal::~DeferredGlobal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.h", line = 312,
   FQN="clang::CodeGen::CodeGenModule::DeferredGlobal::~DeferredGlobal", NM="_ZN5clang7CodeGen13CodeGenModule14DeferredGlobalD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDeclCXX.cpp -nm=_ZN5clang7CodeGen13CodeGenModule14DeferredGlobalD0Ev")
  //</editor-fold>
  public final /*inline*/ void $destroy() {
    //START JDestroy
    GV.$destroy();
    //END JDestroy
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public DeferredGlobal() { 
    this.GV = new TrackingVH<GlobalValue>(GlobalValue.class);
    this.GD = new GlobalDecl();
  }

  @Override public DeferredGlobal clone() { 
    return new DeferredGlobal(this); 
  }
  

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "GV=" + GV // NOI18N
              + ", GD=" + "[GlobalDecl]"; // NOI18N
  }
  }
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::GlobalInitPriorityCmp">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.h", line = 406,
 FQN="clang::CodeGen::CodeGenModule::GlobalInitPriorityCmp", NM="_ZN5clang7CodeGen13CodeGenModule21GlobalInitPriorityCmpE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDeclCXX.cpp -nm=_ZN5clang7CodeGen13CodeGenModule21GlobalInitPriorityCmpE")
//</editor-fold>
protected/*private*/ static class/*struct*/ GlobalInitPriorityCmp implements Native.ComparatorLower<std.pair<OrderGlobalInits, Function /*P*/ >, std.pair<OrderGlobalInits, Function /*P*/ >>{
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::GlobalInitPriorityCmp::operator()">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.h", line = 407,
   FQN="clang::CodeGen::CodeGenModule::GlobalInitPriorityCmp::operator()", NM="_ZNK5clang7CodeGen13CodeGenModule21GlobalInitPriorityCmpclERKSt4pairINS0_16OrderGlobalInitsEPN4llvm8FunctionEESA_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDeclCXX.cpp -nm=_ZNK5clang7CodeGen13CodeGenModule21GlobalInitPriorityCmpclERKSt4pairINS0_16OrderGlobalInitsEPN4llvm8FunctionEESA_")
  //</editor-fold>
  public final boolean $call(final /*const*/std.pairTypePtr<OrderGlobalInits, Function /*P*/ > /*&*/ LHS, 
       final /*const*/std.pairTypePtr<OrderGlobalInits, Function /*P*/ > /*&*/ RHS) /*const*/ {
    return $less_uint(LHS.first.priority, RHS.first.priority);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::GlobalInitPriorityCmp::GlobalInitPriorityCmp">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.h", line = 406,
   FQN="clang::CodeGen::CodeGenModule::GlobalInitPriorityCmp::GlobalInitPriorityCmp", NM="_ZN5clang7CodeGen13CodeGenModule21GlobalInitPriorityCmpC1ERKS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDeclCXX.cpp -nm=_ZN5clang7CodeGen13CodeGenModule21GlobalInitPriorityCmpC1ERKS2_")
  //</editor-fold>
  public /*inline*/ GlobalInitPriorityCmp(final /*const*/ GlobalInitPriorityCmp /*&*/ $Prm0) {
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::GlobalInitPriorityCmp::GlobalInitPriorityCmp">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.h", line = 406,
   FQN="clang::CodeGen::CodeGenModule::GlobalInitPriorityCmp::GlobalInitPriorityCmp", NM="_ZN5clang7CodeGen13CodeGenModule21GlobalInitPriorityCmpC1EOS2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDeclCXX.cpp -nm=_ZN5clang7CodeGen13CodeGenModule21GlobalInitPriorityCmpC1EOS2_")
  //</editor-fold>
  public /*inline*/ GlobalInitPriorityCmp(JD$Move _dparam, final GlobalInitPriorityCmp /*&&*/$Prm0) {
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public GlobalInitPriorityCmp() { }

  @Override
  public boolean $less(std_pair.pair<OrderGlobalInits, Function> LHS, std_pair.pair<OrderGlobalInits, Function> RHS) {
    return $call(LHS, RHS);
  }


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return ""; // NOI18N
  }
  }
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.h", line = 468,
 FQN="clang::CodeGen::CodeGenModule::(anonymous)", NM="_ZN5clang7CodeGen13CodeGenModuleE_Unnamed_struct4",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDeclCXX.cpp -nm=_ZN5clang7CodeGen13CodeGenModuleE_Unnamed_struct4")
//</editor-fold>
protected/*private*/ static class/*struct*/ Unnamed_struct4 {
  public int GlobalUniqueCount;

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::(anonymous struct)::">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.h", line = 468,
   FQN="clang::CodeGen::CodeGenModule::(anonymous struct)::", NM="_ZN5clang7CodeGen13CodeGenModuleUt_C1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen13CodeGenModuleUt_C1Ev")
  //</editor-fold>
  public /*inline*/ Unnamed_struct4() {
  }

  
  @Override public String toString() {
    return "" + "GlobalUniqueCount=" + GlobalUniqueCount; // NOI18N
  }
}
} // END OF class CodeGenModule_NestedClasses
