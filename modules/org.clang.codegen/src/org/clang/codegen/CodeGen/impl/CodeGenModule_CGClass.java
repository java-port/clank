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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Native.*;
import org.clang.ast.*;
import org.llvm.ir.*;
import org.llvm.ir.Type;
import static org.clang.ast.java.AstDeclarationsRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type CodeGenModule_CGClass">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.clang.codegen.CodeGen.impl.CodeGenModule_CGClass",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this -extends=CodeGenModule_CGCall ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZN5clang7CodeGen13CodeGenModule17getVBaseAlignmentENS_9CharUnitsEPKNS_13CXXRecordDeclES5_;_ZN5clang7CodeGen13CodeGenModule24getClassPointerAlignmentEPKNS_13CXXRecordDeclE;_ZN5clang7CodeGen13CodeGenModule25getDynamicOffsetAlignmentENS_9CharUnitsEPKNS_13CXXRecordDeclES2_;_ZN5clang7CodeGen13CodeGenModule28GetNonVirtualBaseClassOffsetEPKNS_13CXXRecordDeclEPKPKNS_16CXXBaseSpecifierES9_;_ZN5clang7CodeGen13CodeGenModule32computeNonVirtualBaseClassOffsetEPKNS_13CXXRecordDeclEPKPKNS_16CXXBaseSpecifierES9_; -static-type=CodeGenModule_CGClass -package=org.clang.codegen.CodeGen.impl")
//</editor-fold>
public abstract class CodeGenModule_CGClass extends CodeGenModule_CGCall {
private final /*split clang::CodeGen::CodeGenModule*/ CodeGenModule $this() { return (CodeGenModule)this; }


/// Returns the assumed alignment of an opaque pointer to the given class.

/// Return the best known alignment for an unknown pointer to a
/// particular class.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::getClassPointerAlignment">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp", line = 36,
 FQN="clang::CodeGen::CodeGenModule::getClassPointerAlignment", NM="_ZN5clang7CodeGen13CodeGenModule24getClassPointerAlignmentEPKNS_13CXXRecordDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZN5clang7CodeGen13CodeGenModule24getClassPointerAlignmentEPKNS_13CXXRecordDeclE")
//</editor-fold>
public final CharUnits getClassPointerAlignment(/*const*/ CXXRecordDecl /*P*/ RD) {
  if (!RD.isCompleteDefinition()) {
    return CharUnits.One(); // Hopefully won't be used anywhere.
  }
  
  final /*const*/ ASTRecordLayout /*&*/ layout = $this().getContext().getASTRecordLayout(RD);
  
  // If the class is final, then we know that the pointer points to an
  // object of that type and can use the full alignment.
  if (RD.hasAttr(FinalAttr.class)) {
    return layout.getAlignment();
    // Otherwise, we have to assume it could be a subclass.
  } else {
    return layout.getNonVirtualAlignment();
  }
}


/// Returns the assumed alignment of a virtual base of a class.

/// Return the best known alignment for a pointer to a virtual base,
/// given the alignment of a pointer to the derived class.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::getVBaseAlignment">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp", line = 55,
 FQN="clang::CodeGen::CodeGenModule::getVBaseAlignment", NM="_ZN5clang7CodeGen13CodeGenModule17getVBaseAlignmentENS_9CharUnitsEPKNS_13CXXRecordDeclES5_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZN5clang7CodeGen13CodeGenModule17getVBaseAlignmentENS_9CharUnitsEPKNS_13CXXRecordDeclES5_")
//</editor-fold>
public final CharUnits getVBaseAlignment(CharUnits actualDerivedAlign, 
                 /*const*/ CXXRecordDecl /*P*/ derivedClass, 
                 /*const*/ CXXRecordDecl /*P*/ vbaseClass) {
  // The basic idea here is that an underaligned derived pointer might
  // indicate an underaligned base pointer.
  assert (vbaseClass.isCompleteDefinition());
  final /*const*/ ASTRecordLayout /*&*/ baseLayout = $this().getContext().getASTRecordLayout(vbaseClass);
  CharUnits expectedVBaseAlign = baseLayout.getNonVirtualAlignment();
  
  return $this().getDynamicOffsetAlignment(new CharUnits(actualDerivedAlign), derivedClass, 
      new CharUnits(expectedVBaseAlign));
}


/// Given a class pointer with an actual known alignment, and the
/// expected alignment of an object at a dynamic offset w.r.t that
/// pointer, return the alignment to assume at the offset.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::getDynamicOffsetAlignment">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp", line = 69,
 FQN="clang::CodeGen::CodeGenModule::getDynamicOffsetAlignment", NM="_ZN5clang7CodeGen13CodeGenModule25getDynamicOffsetAlignmentENS_9CharUnitsEPKNS_13CXXRecordDeclES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZN5clang7CodeGen13CodeGenModule25getDynamicOffsetAlignmentENS_9CharUnitsEPKNS_13CXXRecordDeclES2_")
//</editor-fold>
public final CharUnits getDynamicOffsetAlignment(CharUnits actualBaseAlign, 
                         /*const*/ CXXRecordDecl /*P*/ baseDecl, 
                         CharUnits expectedTargetAlign) {
  // If the base is an incomplete type (which is, alas, possible with
  // member pointers), be pessimistic.
  if (!baseDecl.isCompleteDefinition()) {
    return new CharUnits(std.min(actualBaseAlign, expectedTargetAlign));
  }
  
  final /*const*/ ASTRecordLayout /*&*/ baseLayout = $this().getContext().getASTRecordLayout(baseDecl);
  CharUnits expectedBaseAlign = baseLayout.getNonVirtualAlignment();
  
  // If the class is properly aligned, assume the target offset is, too.
  //
  // This actually isn't necessarily the right thing to do --- if the
  // class is a complete object, but it's only properly aligned for a
  // base subobject, then the alignments of things relative to it are
  // probably off as well.  (Note that this requires the alignment of
  // the target to be greater than the NV alignment of the derived
  // class.)
  //
  // However, our approach to this kind of under-alignment can only
  // ever be best effort; after all, we're never going to propagate
  // alignments through variables or parameters.  Note, in particular,
  // that constructing a polymorphic type in an address that's less
  // than pointer-aligned will generally trap in the constructor,
  // unless we someday add some sort of attribute to change the
  // assumed alignment of 'this'.  So our goal here is pretty much
  // just to allow the user to explicitly say that a pointer is
  // under-aligned and then safely access its fields and vtables.
  if (actualBaseAlign.$greatereq(expectedBaseAlign)) {
    return new CharUnits(JD$Move.INSTANCE, expectedTargetAlign);
  }
  
  // Otherwise, we might be offset by an arbitrary multiple of the
  // actual alignment.  The correct adjustment is to take the min of
  // the two alignments.
  return new CharUnits(std.min(actualBaseAlign, expectedTargetAlign));
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::computeNonVirtualBaseClassOffset">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp", line = 147,
 FQN="clang::CodeGen::CodeGenModule::computeNonVirtualBaseClassOffset", NM="_ZN5clang7CodeGen13CodeGenModule32computeNonVirtualBaseClassOffsetEPKNS_13CXXRecordDeclEPKPKNS_16CXXBaseSpecifierES9_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZN5clang7CodeGen13CodeGenModule32computeNonVirtualBaseClassOffsetEPKNS_13CXXRecordDeclEPKPKNS_16CXXBaseSpecifierES9_")
//</editor-fold>
public final CharUnits computeNonVirtualBaseClassOffset(/*const*/ CXXRecordDecl /*P*/ DerivedClass, type$ptr</*const*/ CXXBaseSpecifier /*P*/ /*const*/ /*P*/> Start, 
                                type$ptr</*const*/ CXXBaseSpecifier /*P*/ /*const*/ /*P*/> End) {
  CharUnits Offset = CharUnits.Zero();
  
  final /*const*/ ASTContext /*&*/ Context = $this().getContext();
  /*const*/ CXXRecordDecl /*P*/ RD = DerivedClass;
  
  for (type$ptr</*const*/ CXXBaseSpecifier /*P*/ /*const*/ /*P*/> I = $tryClone(Start); $noteq_ptr(I, End); I.$preInc()) {
    /*const*/ CXXBaseSpecifier /*P*/ Base = I.$star();
    assert (!Base.isVirtual()) : "Should not see virtual bases here!";
    
    // Get the layout.
    final /*const*/ ASTRecordLayout /*&*/ Layout = Context.getASTRecordLayout(RD);
    
    /*const*/ CXXRecordDecl /*P*/ BaseDecl = cast_CXXRecordDecl(Base.getType().$arrow().getAs$RecordType().getDecl());
    
    // Add the offset.
    Offset.$addassign(Layout.getBaseClassOffset(BaseDecl));
    
    RD = BaseDecl;
  }
  
  return Offset;
}


/// Returns the offset from a derived class to  a class. Returns null if the
/// offset is 0.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::GetNonVirtualBaseClassOffset">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp", line = 174,
 FQN="clang::CodeGen::CodeGenModule::GetNonVirtualBaseClassOffset", NM="_ZN5clang7CodeGen13CodeGenModule28GetNonVirtualBaseClassOffsetEPKNS_13CXXRecordDeclEPKPKNS_16CXXBaseSpecifierES9_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGClass.cpp -nm=_ZN5clang7CodeGen13CodeGenModule28GetNonVirtualBaseClassOffsetEPKNS_13CXXRecordDeclEPKPKNS_16CXXBaseSpecifierES9_")
//</editor-fold>
public final Constant /*P*/ GetNonVirtualBaseClassOffset(/*const*/ CXXRecordDecl /*P*/ ClassDecl, 
                            type$ptr</*const*/ CXXBaseSpecifier /*P*/ /*const*/ /*P*/> PathBegin, 
                            type$ptr</*const*/ CXXBaseSpecifier /*P*/ /*const*/ /*P*/> PathEnd) {
  assert ($noteq_ptr(PathBegin, PathEnd)) : "Base path should not be empty!";
  
  CharUnits Offset = $this().computeNonVirtualBaseClassOffset(ClassDecl, PathBegin, PathEnd);
  if (Offset.isZero()) {
    return null;
  }
  
  Type /*P*/ PtrDiffTy = $this().Types.ConvertType($this().getContext().getPointerDiffType());
  
  return ConstantInt.get(PtrDiffTy, Offset.getQuantity());
}

} // END OF class CodeGenModule_CGClass
