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

package org.clang.codegen;

import org.clank.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.llvm.ir.*;
import org.llvm.ir.Module;
import org.clang.codegen.impl.*;
import org.clang.codegen.CodeGen.impl.*;


/// The primary public interface to the Clang code generator.
///
/// This is not really an abstract interface.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGenerator">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/ModuleBuilder.h", line = 42,
 FQN="clang::CodeGenerator", NM="_ZN5clang13CodeGeneratorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp -nm=_ZN5clang13CodeGeneratorE")
//</editor-fold>
public class CodeGenerator extends /*public*/ ASTConsumer implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGenerator::anchor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp", line = 288,
   FQN="clang::CodeGenerator::anchor", NM="_ZN5clang13CodeGenerator6anchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp -nm=_ZN5clang13CodeGenerator6anchorEv")
  //</editor-fold>
  protected/*private*/ void anchor() {
  }

/*public:*/
  /// Return an opaque reference to the CodeGenModule object, which can
  /// be used in various secondary APIs.  It is valid as long as the
  /// CodeGenerator exists.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGenerator::CGM">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp", line = 290,
   FQN="clang::CodeGenerator::CGM", NM="_ZN5clang13CodeGenerator3CGMEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp -nm=_ZN5clang13CodeGenerator3CGMEv")
  //</editor-fold>
  public CodeGenModule /*&*/ CGM() {
    return ((/*static_cast*/CodeGeneratorImpl /*P*/ )(this)).CGM();
  }

  
  /// Return the module that this code generator is building into.
  ///
  /// This may return null after HandleTranslationUnit is called;
  /// this signifies that there was an error generating code.  A
  /// diagnostic will have been generated in this case, and the module
  /// will be deleted.
  ///
  /// It will also return null if the module is released.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGenerator::GetModule">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp", line = 294,
   FQN="clang::CodeGenerator::GetModule", NM="_ZN5clang13CodeGenerator9GetModuleEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp -nm=_ZN5clang13CodeGenerator9GetModuleEv")
  //</editor-fold>
  public org.llvm.ir.Module /*P*/ GetModule() {
    return ((/*static_cast*/CodeGeneratorImpl /*P*/ )(this)).GetModule();
  }

  
  /// Release ownership of the module to the caller.
  ///
  /// It is illegal to call methods other than GetModule on the
  /// CodeGenerator after releasing its module.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGenerator::ReleaseModule">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp", line = 298,
   FQN="clang::CodeGenerator::ReleaseModule", NM="_ZN5clang13CodeGenerator13ReleaseModuleEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp -nm=_ZN5clang13CodeGenerator13ReleaseModuleEv")
  //</editor-fold>
  public org.llvm.ir.Module /*P*/ ReleaseModule() {
    return ((/*static_cast*/CodeGeneratorImpl /*P*/ )(this)).ReleaseModule();
  }

  
  /// Given a mangled name, return a declaration which mangles that way
  /// which has been added to this code generator via a Handle method.
  ///
  /// This may return null if there was no matching declaration.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGenerator::GetDeclForMangledName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp", line = 302,
   FQN="clang::CodeGenerator::GetDeclForMangledName", NM="_ZN5clang13CodeGenerator21GetDeclForMangledNameEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp -nm=_ZN5clang13CodeGenerator21GetDeclForMangledNameEN4llvm9StringRefE")
  //</editor-fold>
  public /*const*/ Decl /*P*/ GetDeclForMangledName(StringRef name) {
    return ((/*static_cast*/CodeGeneratorImpl /*P*/ )(this)).GetDeclForMangledName(new StringRef(name));
  }

  
  /// Return the LLVM address of the given global entity.
  ///
  /// \param isForDefinition If true, the caller intends to define the
  ///   entity; the object returned will be an llvm::GlobalValue of
  ///   some sort.  If false, the caller just intends to use the entity;
  ///   the object returned may be any sort of constant value, and the
  ///   code generator will schedule the entity for emission if a
  ///   definition has been registered with this code generator.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGenerator::GetAddrOfGlobal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp", line = 306,
   FQN="clang::CodeGenerator::GetAddrOfGlobal", NM="_ZN5clang13CodeGenerator15GetAddrOfGlobalENS_10GlobalDeclEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp -nm=_ZN5clang13CodeGenerator15GetAddrOfGlobalENS_10GlobalDeclEb")
  //</editor-fold>
  public Constant /*P*/ GetAddrOfGlobal(GlobalDecl global, 
                 boolean isForDefinition) {
    return ((/*static_cast*/CodeGeneratorImpl /*P*/ )(this)).
        GetAddrOfGlobal(new GlobalDecl(global), isForDefinition);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGenerator::~CodeGenerator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/ModuleBuilder.h", line = 42,
   FQN="clang::CodeGenerator::~CodeGenerator", NM="_ZN5clang13CodeGeneratorD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp -nm=_ZN5clang13CodeGeneratorD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGenerator::CodeGenerator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/CodeGen/ModuleBuilder.h", line = 42,
   FQN="clang::CodeGenerator::CodeGenerator", NM="_ZN5clang13CodeGeneratorC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ModuleBuilder.cpp -nm=_ZN5clang13CodeGeneratorC1Ev")
  //</editor-fold>
  public /*inline*/ CodeGenerator() {
    // : ASTConsumer() 
    //START JInit
    super();
    //END JInit
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
