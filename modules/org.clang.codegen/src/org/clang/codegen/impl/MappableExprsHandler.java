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

package org.clang.codegen.impl;

import org.clank.java.*;
import org.clank.support.*;
import static org.llvm.adt.ADTAliases.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.llvm.ir.*;
import org.clang.codegen.impl.*;
import org.clang.codegen.CodeGen.impl.*;
import org.clang.codegen.java.ClangCodeGenFunctionPointers.*;
import org.clang.ast.java.AstTypesRTTI;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;

// \brief Utility to handle information from clauses associated with a given
// construct that use mappable expressions (e.g. 'map' clause, 'to' clause).
// It provides a convenient interface to obtain the information and generate
// code for that information.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MappableExprsHandler">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 4961,
 FQN="(anonymous namespace)::MappableExprsHandler", NM="_ZN12_GLOBAL__N_120MappableExprsHandlerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN12_GLOBAL__N_120MappableExprsHandlerE")
//</editor-fold>
public class MappableExprsHandler implements Destructors.ClassWithDestructor {
/*public:*/
  /// \brief Values for bit flags used to specify the mapping type for
  /// offloading.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MappableExprsHandler::OpenMPOffloadMappingFlags">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 4965,
   FQN="(anonymous namespace)::MappableExprsHandler::OpenMPOffloadMappingFlags", NM="_ZN12_GLOBAL__N_120MappableExprsHandler25OpenMPOffloadMappingFlagsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN12_GLOBAL__N_120MappableExprsHandler25OpenMPOffloadMappingFlagsE")
  //</editor-fold>
  public static final class/*enum*/ OpenMPOffloadMappingFlags {
    /// \brief Allocate memory on the device and move data from host to device.
    public static final /*uint*/int OMP_MAP_TO = 0x01;
    /// \brief Allocate memory on the device and move data from device to host.
    public static final /*uint*/int OMP_MAP_FROM = 0x02;
    /// \brief Always perform the requested mapping action on the element, even
    /// if it was already mapped before.
    public static final /*uint*/int OMP_MAP_ALWAYS = 0x04;
    /// \brief Delete the element from the device environment, ignoring the
    /// current reference count associated with the element.
    public static final /*uint*/int OMP_MAP_DELETE = 0x08;
    /// \brief The element being mapped is a pointer, therefore the pointee
    /// should be mapped as well.
    public static final /*uint*/int OMP_MAP_IS_PTR = 0x10;
    /// \brief This flags signals that an argument is the first one relating to
    /// a map/private clause expression. For some cases a single
    /// map/privatization results in multiple arguments passed to the runtime
    /// library.
    public static final /*uint*/int OMP_MAP_FIRST_REF = 0x20;
    /// \brief This flag signals that the reference being passed is a pointer to
    /// private data.
    public static final /*uint*/int OMP_MAP_PRIVATE_PTR = 0x80;
    /// \brief Pass the element to the device by value.
    public static final /*uint*/int OMP_MAP_PRIVATE_VAL = 0x100;
  };
  
  // JAVA: typedef SmallVector<llvm::Value *, 16> MapValuesArrayTy
//  public final class MapValuesArrayTy extends SmallVector<Value /*P*/ >{ };
  // JAVA: typedef SmallVector<unsigned int, 16> MapFlagsArrayTy
//  public final class MapFlagsArrayTy extends SmallVectorUInt{ };
/*private:*/
  /// \brief Directive from where the map clauses were extracted.
  private final /*const*/ OMPExecutableDirective /*&*/ Directive;
  
  /// \brief Function the directive is being generated for.
  private final CodeGenFunction /*&*/ CGF;
  
  /// \brief Set of all first private variables in the current directive.
  private SmallPtrSet</*const*/ VarDecl /*P*/ > FirstPrivateDecls;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MappableExprsHandler::getExprTypeSize">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 5004,
   FQN="(anonymous namespace)::MappableExprsHandler::getExprTypeSize", NM="_ZNK12_GLOBAL__N_120MappableExprsHandler15getExprTypeSizeEPKN5clang4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZNK12_GLOBAL__N_120MappableExprsHandler15getExprTypeSizeEPKN5clang4ExprE")
  //</editor-fold>
  private Value /*P*/ getExprTypeSize(/*const*/ Expr /*P*/ E) /*const*/ {
    QualType ExprTy = E.getType().getCanonicalType();
    {
      
      // Reference types are ignored for mapping purposes.
      /*const*/ ReferenceType /*P*/ RefTy = ExprTy.$arrow().getAs(ReferenceType.class);
      if ((RefTy != null)) {
        ExprTy.$assignMove(RefTy.getPointeeType().getCanonicalType());
      }
    }
    {
      
      // Given that an array section is considered a built-in type, we need to
      // do the calculation based on the length of the section instead of relying
      // on CGF.getTypeSize(E->getType()).
      /*const*/ OMPArraySectionExpr /*P*/ OAE = dyn_cast_OMPArraySectionExpr(E);
      if ((OAE != null)) {
        QualType BaseTy = OMPArraySectionExpr.getBaseOriginalType(OAE.getBase$Const().IgnoreParenImpCasts$Const()).
            getCanonicalType();
        
        // If there is no length associated with the expression, that means we
        // are using the whole length of the base.
        if (!(OAE.getLength$Const() != null) && OAE.getColonLoc().isValid()) {
          return CGF.getTypeSize(new QualType(BaseTy));
        }
        
        Value /*P*/ ElemSize;
        {
          /*const*/ org.clang.ast.PointerType /*P*/ PTy = BaseTy.$arrow().getAs(org.clang.ast.PointerType.class);
          if ((PTy != null)) {
            ElemSize = CGF.getTypeSize(PTy.getPointeeType().getCanonicalType());
          } else {
            /*const*/ org.clang.ast.ArrayType /*P*/ ATy = AstTypesRTTI.cast_ArrayType(BaseTy.getTypePtr());
            assert ((ATy != null)) : "Expecting array type if not a pointer type.";
            ElemSize = CGF.getTypeSize(ATy.getElementType().getCanonicalType());
          }
        }
        
        // If we don't have a length at this point, that is because we have an
        // array section with a single element.
        if (!(OAE.getLength$Const() != null)) {
          return ElemSize;
        }
        
        Value /*P*/ LengthVal = CGF.EmitScalarExpr(OAE.getLength$Const());
        LengthVal
           = CGF.Builder.CreateIntCast(LengthVal, CGF.Unnamed_field8.SizeTy, /*isSigned=*/ false);
        return CGF.Builder.CreateNUWMul(LengthVal, ElemSize);
      }
    }
    return CGF.getTypeSize(new QualType(ExprTy));
  }

  
  /// \brief Return the corresponding bits for a given map clause modifier. Add
  /// a flag marking the map as a pointer if requested. Add a flag marking the
  /// map as the first one of a series of maps that relate to the same map
  /// expression.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MappableExprsHandler::getMapTypeBits">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 5050,
   FQN="(anonymous namespace)::MappableExprsHandler::getMapTypeBits", NM="_ZNK12_GLOBAL__N_120MappableExprsHandler14getMapTypeBitsEN5clang19OpenMPMapClauseKindES2_bb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZNK12_GLOBAL__N_120MappableExprsHandler14getMapTypeBitsEN5clang19OpenMPMapClauseKindES2_bb")
  //</editor-fold>
  private /*uint*/int getMapTypeBits(OpenMPMapClauseKind MapType, 
                OpenMPMapClauseKind MapTypeModifier, boolean AddPtrFlag, 
                boolean AddIsFirstFlag) /*const*/ {
    /*uint*/int Bits = 0/*U*/;
    switch (MapType) {
     case OMPC_MAP_alloc:
     case OMPC_MAP_release:
      // alloc and release is the default behavior in the runtime library,  i.e.
      // if we don't pass any bits alloc/release that is what the runtime is
      // going to do. Therefore, we don't need to signal anything for these two
      // type modifiers.
      break;
     case OMPC_MAP_to:
      Bits = OpenMPOffloadMappingFlags.OMP_MAP_TO;
      break;
     case OMPC_MAP_from:
      Bits = OpenMPOffloadMappingFlags.OMP_MAP_FROM;
      break;
     case OMPC_MAP_tofrom:
      Bits = OpenMPOffloadMappingFlags.OMP_MAP_TO | OpenMPOffloadMappingFlags.OMP_MAP_FROM;
      break;
     case OMPC_MAP_delete:
      Bits = OpenMPOffloadMappingFlags.OMP_MAP_DELETE;
      break;
     default:
      throw new llvm_unreachable("Unexpected map type!");
//      break;
    }
    if (AddPtrFlag) {
      Bits |= OpenMPOffloadMappingFlags.OMP_MAP_IS_PTR;
    }
    if (AddIsFirstFlag) {
      Bits |= OpenMPOffloadMappingFlags.OMP_MAP_FIRST_REF;
    }
    if (MapTypeModifier == OpenMPMapClauseKind.OMPC_MAP_always) {
      Bits |= OpenMPOffloadMappingFlags.OMP_MAP_ALWAYS;
    }
    return Bits;
  }

  
  /// \brief Return true if the provided expression is a final array section. A
  /// final array section, is one whose length can't be proved to be one.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MappableExprsHandler::isFinalArraySectionExpression">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 5089,
   FQN="(anonymous namespace)::MappableExprsHandler::isFinalArraySectionExpression", NM="_ZNK12_GLOBAL__N_120MappableExprsHandler29isFinalArraySectionExpressionEPKN5clang4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZNK12_GLOBAL__N_120MappableExprsHandler29isFinalArraySectionExpressionEPKN5clang4ExprE")
  //</editor-fold>
  private boolean isFinalArraySectionExpression(/*const*/ Expr /*P*/ E) /*const*/ {
    /*const*/ OMPArraySectionExpr /*P*/ OASE = dyn_cast_OMPArraySectionExpr(E);
    
    // It is not an array section and therefore not a unity-size one.
    if (!(OASE != null)) {
      return false;
    }
    
    // An array section with no colon always refer to a single element.
    if (OASE.getColonLoc().isInvalid()) {
      return false;
    }
    
    /*const*/ Expr /*P*/ Length = OASE.getLength$Const();
    
    // If we don't have a length we have to check if the array has size 1
    // for this dimension. Also, we should always expect a length if the
    // base type is pointer.
    if (!(Length != null)) {
      QualType BaseQTy = OMPArraySectionExpr.getBaseOriginalType(OASE.getBase$Const().IgnoreParenImpCasts$Const()).
          getCanonicalType();
      {
        /*const*/ ConstantArrayType /*P*/ ATy = AstTypesRTTI.dyn_cast_ConstantArrayType(BaseQTy.getTypePtr());
        if ((ATy != null)) {
          return ATy.getSize().getSExtValue() != 1;
        }
      }
      // If we don't have a constant dimension length, we have to consider
      // the current section as having any size, so it is not necessarily
      // unitary. If it happen to be unity size, that's user fault.
      return true;
    }
    
    // Check if the length evaluates to 1.
    APSInt ConstLength/*J*/= new APSInt();
    if (!Length.EvaluateAsInt(ConstLength, CGF.getContext())) {
      return true; // Can have more that size 1.
    }
    
    return ConstLength.getSExtValue() != 1;
  }

  
  /// \brief Generate the base pointers, section pointers, sizes and map type
  /// bits for the provided map type, map modifier, and expression components.
  /// \a IsFirstComponent should be set to true if the provided set of
  /// components is the first associated with a capture.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MappableExprsHandler::generateInfoForComponentList">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 5129,
   FQN="(anonymous namespace)::MappableExprsHandler::generateInfoForComponentList", NM="_ZNK12_GLOBAL__N_120MappableExprsHandler28generateInfoForComponentListEN5clang19OpenMPMapClauseKindES2_N4llvm8ArrayRefINS1_27OMPClauseMappableExprCommon17MappableComponentEEERNS3_11SmallVectorIPNS3_5ValueELj16EEESC_SC_RNS8_IjLj16EEEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZNK12_GLOBAL__N_120MappableExprsHandler28generateInfoForComponentListEN5clang19OpenMPMapClauseKindES2_N4llvm8ArrayRefINS1_27OMPClauseMappableExprCommon17MappableComponentEEERNS3_11SmallVectorIPNS3_5ValueELj16EEESC_SC_RNS8_IjLj16EEEb")
  //</editor-fold>
  private void generateInfoForComponentList(OpenMPMapClauseKind MapType, OpenMPMapClauseKind MapTypeModifier, 
                              ArrayRef<OMPClauseMappableExprCommon.MappableComponent> Components, 
                              final SmallVector<Value /*P*/ > /*&*/ BasePointers, final SmallVector<Value /*P*/ > /*&*/ Pointers, 
                              final SmallVector<Value /*P*/ > /*&*/ Sizes, final SmallVectorUInt /*&*/ Types, 
                              boolean IsFirstComponentList) /*const*/ {
    
    // The following summarizes what has to be generated for each map and the
    // types bellow. The generated information is expressed in this order:
    // base pointer, section pointer, size, flags
    // (to add to the ones that come from the map type and modifier).
    //
    // double d;
    // int i[100];
    // float *p;
    //
    // struct S1 {
    //   int i;
    //   float f[50];
    // }
    // struct S2 {
    //   int i;
    //   float f[50];
    //   S1 s;
    //   double *p;
    //   struct S2 *ps;
    // }
    // S2 s;
    // S2 *ps;
    //
    // map(d)
    // &d, &d, sizeof(double), noflags
    //
    // map(i)
    // &i, &i, 100*sizeof(int), noflags
    //
    // map(i[1:23])
    // &i(=&i[0]), &i[1], 23*sizeof(int), noflags
    //
    // map(p)
    // &p, &p, sizeof(float*), noflags
    //
    // map(p[1:24])
    // p, &p[1], 24*sizeof(float), noflags
    //
    // map(s)
    // &s, &s, sizeof(S2), noflags
    //
    // map(s.i)
    // &s, &(s.i), sizeof(int), noflags
    //
    // map(s.s.f)
    // &s, &(s.i.f), 50*sizeof(int), noflags
    //
    // map(s.p)
    // &s, &(s.p), sizeof(double*), noflags
    //
    // map(s.p[:22], s.a s.b)
    // &s, &(s.p), sizeof(double*), noflags
    // &(s.p), &(s.p[0]), 22*sizeof(double), ptr_flag + extra_flag
    //
    // map(s.ps)
    // &s, &(s.ps), sizeof(S2*), noflags
    //
    // map(s.ps->s.i)
    // &s, &(s.ps), sizeof(S2*), noflags
    // &(s.ps), &(s.ps->s.i), sizeof(int), ptr_flag + extra_flag
    //
    // map(s.ps->ps)
    // &s, &(s.ps), sizeof(S2*), noflags
    // &(s.ps), &(s.ps->ps), sizeof(S2*), ptr_flag + extra_flag
    //
    // map(s.ps->ps->ps)
    // &s, &(s.ps), sizeof(S2*), noflags
    // &(s.ps), &(s.ps->ps), sizeof(S2*), ptr_flag + extra_flag
    // &(s.ps->ps), &(s.ps->ps->ps), sizeof(S2*), ptr_flag + extra_flag
    //
    // map(s.ps->ps->s.f[:22])
    // &s, &(s.ps), sizeof(S2*), noflags
    // &(s.ps), &(s.ps->ps), sizeof(S2*), ptr_flag + extra_flag
    // &(s.ps->ps), &(s.ps->ps->s.f[0]), 22*sizeof(float), ptr_flag + extra_flag
    //
    // map(ps)
    // &ps, &ps, sizeof(S2*), noflags
    //
    // map(ps->i)
    // ps, &(ps->i), sizeof(int), noflags
    //
    // map(ps->s.f)
    // ps, &(ps->s.f[0]), 50*sizeof(float), noflags
    //
    // map(ps->p)
    // ps, &(ps->p), sizeof(double*), noflags
    //
    // map(ps->p[:22])
    // ps, &(ps->p), sizeof(double*), noflags
    // &(ps->p), &(ps->p[0]), 22*sizeof(double), ptr_flag + extra_flag
    //
    // map(ps->ps)
    // ps, &(ps->ps), sizeof(S2*), noflags
    //
    // map(ps->ps->s.i)
    // ps, &(ps->ps), sizeof(S2*), noflags
    // &(ps->ps), &(ps->ps->s.i), sizeof(int), ptr_flag + extra_flag
    //
    // map(ps->ps->ps)
    // ps, &(ps->ps), sizeof(S2*), noflags
    // &(ps->ps), &(ps->ps->ps), sizeof(S2*), ptr_flag + extra_flag
    //
    // map(ps->ps->ps->ps)
    // ps, &(ps->ps), sizeof(S2*), noflags
    // &(ps->ps), &(ps->ps->ps), sizeof(S2*), ptr_flag + extra_flag
    // &(ps->ps->ps), &(ps->ps->ps->ps), sizeof(S2*), ptr_flag + extra_flag
    //
    // map(ps->ps->ps->s.f[:22])
    // ps, &(ps->ps), sizeof(S2*), noflags
    // &(ps->ps), &(ps->ps->ps), sizeof(S2*), ptr_flag + extra_flag
    // &(ps->ps->ps), &(ps->ps->ps->s.f[0]), 22*sizeof(float), ptr_flag +
    // extra_flag
    
    // Track if the map information being generated is the first for a capture.
    boolean IsCaptureFirstInfo = IsFirstComponentList;
    
    // Scan the components from the base to the complete expression.
    std.reverse_iterator</*const*/ OMPClauseMappableExprCommon.MappableComponent> CI = Components.rbegin();
    std.reverse_iterator</*const*/ OMPClauseMappableExprCommon.MappableComponent> CE = Components.rend();
    std.reverse_iterator</*const*/ OMPClauseMappableExprCommon.MappableComponent> I = new std.reverse_iterator</*const*/ OMPClauseMappableExprCommon.MappableComponent>(CI);
    
    // Track if the map information being generated is the first for a list of
    // components.
    boolean IsExpressionFirstInfo = true;
    Value /*P*/ BP = null;
    {
      
      MemberExpr /*P*/ ME = dyn_cast_MemberExpr(I.$arrow().getAssociatedExpression());
      if ((ME != null)) {
        // The base is the 'this' pointer. The content of the pointer is going
        // to be the base of the field being mapped.
        BP = CGF.EmitScalarExpr(ME.getBase());
      } else {
        // The base is the reference to the variable.
        // BP = &Var.
        BP = CGF.EmitLValue(cast_DeclRefExpr(I.$arrow().getAssociatedExpression())).
            getPointer();
        
        // If the variable is a pointer and is being dereferenced (i.e. is not
        // the last component), the base has to be the pointer itself, not its
        // reference.
        if (I.$arrow().getAssociatedDeclaration().getType().$arrow().isAnyPointerType()
           && $noteq_reverse_iterator$C(std.next(new std.reverse_iterator</*const*/ OMPClauseMappableExprCommon.MappableComponent>(I)), CE)) {
          LValue PtrAddr = CGF.MakeNaturalAlignAddrLValue(BP, I.$arrow().getAssociatedDeclaration().getType());
          BP = CGF.EmitLoadOfPointerLValue(PtrAddr.getAddress(), 
              I.$arrow().getAssociatedDeclaration().
    getType().$arrow().getAs(org.clang.ast.PointerType.class)).
              getPointer();
          
          // We do not need to generate individual map information for the
          // pointer, it can be associated with the combined storage.
          I.$preInc();
        }
      }
    }
    
    for (; $noteq_reverse_iterator$C(I, CE); I.$preInc()) {
      std.reverse_iterator</*const*/ OMPClauseMappableExprCommon.MappableComponent> Next = std.next(new std.reverse_iterator</*const*/ OMPClauseMappableExprCommon.MappableComponent>(I));
      
      // We need to generate the addresses and sizes if this is the last
      // component, if the component is a pointer or if it is an array section
      // whose length can't be proved to be one. If this is a pointer, it
      // becomes the base address for the following components.
      
      // A final array section, is one whose length can't be proved to be one.
      boolean IsFinalArraySection = isFinalArraySectionExpression(I.$arrow().getAssociatedExpression());
      
      // Get information on whether the element is a pointer. Have to do a
      // special treatment for array sections given that they are built-in
      // types.
      /*const*/ OMPArraySectionExpr /*P*/ OASE = dyn_cast_OMPArraySectionExpr(I.$arrow().getAssociatedExpression());
      boolean IsPointer = ((OASE != null)
         && OMPArraySectionExpr.getBaseOriginalType(OASE).
          getCanonicalType().$arrow().
          isAnyPointerType())
         || I.$arrow().getAssociatedExpression().getType().$arrow().isAnyPointerType();
      if ($eq_reverse_iterator$C(Next, CE) || IsPointer || IsFinalArraySection) {
        
        // If this is not the last component, we expect the pointer to be
        // associated with an array expression or member expression.
        assert (($eq_reverse_iterator$C(Next, CE) || isa_MemberExpr(Next.$arrow().getAssociatedExpression()) || isa_ArraySubscriptExpr(Next.$arrow().getAssociatedExpression()) || isa_OMPArraySectionExpr(Next.$arrow().getAssociatedExpression()))) : "Unexpected expression";
        
        // Save the base we are currently using.
        BasePointers.push_back(BP);
        
        Value /*P*/ LB = CGF.EmitLValue(I.$arrow().getAssociatedExpression()).getPointer();
        Value /*P*/ Size = getExprTypeSize(I.$arrow().getAssociatedExpression());
        
        Pointers.push_back(LB);
        Sizes.push_back(Size);
        // We need to add a pointer flag for each map that comes from the
        // same expression except for the first one. We also need to signal
        // this map is the first one that relates with the current capture
        // (there is a set of entries for each capture).
        Types.push_back(getMapTypeBits(MapType, MapTypeModifier, 
                !IsExpressionFirstInfo, 
                IsCaptureFirstInfo));
        
        // If we have a final array section, we are done with this expression.
        if (IsFinalArraySection) {
          break;
        }
        
        // The pointer becomes the base for the next element.
        if ($noteq_reverse_iterator$C(Next, CE)) {
          BP = LB;
        }
        
        IsExpressionFirstInfo = false;
        IsCaptureFirstInfo = false;
        continue;
      }
    }
  }

  
  /// \brief Return the adjusted map modifiers if the declaration a capture
  /// refers to appears in a first-private clause. This is expected to be used
  /// only with directives that start with 'target'.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MappableExprsHandler::adjustMapModifiersForPrivateClauses">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 5359,
   FQN="(anonymous namespace)::MappableExprsHandler::adjustMapModifiersForPrivateClauses", NM="_ZN12_GLOBAL__N_120MappableExprsHandler35adjustMapModifiersForPrivateClausesERKN5clang12CapturedStmt7CaptureEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN12_GLOBAL__N_120MappableExprsHandler35adjustMapModifiersForPrivateClausesERKN5clang12CapturedStmt7CaptureEj")
  //</editor-fold>
  private /*uint*/int adjustMapModifiersForPrivateClauses(final /*const*/ CapturedStmt.Capture /*&*/ Cap, 
                                     /*uint*/int CurrentModifiers) {
    assert (Cap.capturesVariable()) : "Expected capture by reference only!";
    
    // A first private variable captured by reference will use only the
    // 'private ptr' and 'map to' flag. Return the right flags if the captured
    // declaration is known as first-private in this handler.
    if ((FirstPrivateDecls.count(Cap.getCapturedVar()) != 0)) {
      return MappableExprsHandler.OpenMPOffloadMappingFlags.OMP_MAP_PRIVATE_PTR
         | MappableExprsHandler.OpenMPOffloadMappingFlags.OMP_MAP_TO;
    }
    
    // We didn't modify anything.
    return CurrentModifiers;
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MappableExprsHandler::MappableExprsHandler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 5375,
   FQN="(anonymous namespace)::MappableExprsHandler::MappableExprsHandler", NM="_ZN12_GLOBAL__N_120MappableExprsHandlerC1ERKN5clang22OMPExecutableDirectiveERNS1_7CodeGen15CodeGenFunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN12_GLOBAL__N_120MappableExprsHandlerC1ERKN5clang22OMPExecutableDirectiveERNS1_7CodeGen15CodeGenFunctionE")
  //</editor-fold>
  public MappableExprsHandler(final /*const*/ OMPExecutableDirective /*&*/ Dir, final CodeGenFunction /*&*/ CGF) {
    // : Directive(Dir), CGF(CGF), FirstPrivateDecls() 
    //START JInit
    this./*&*/Directive=/*&*/Dir;
    this./*&*/CGF=/*&*/CGF;
    this.FirstPrivateDecls = new SmallPtrSet</*const*/ VarDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), 8);
    //END JInit
    // Extract firstprivate clause information.
    for (/*const*/ OMPFirstprivateClause /*P*/ C : Dir.<OMPFirstprivateClause>getClausesOfKind(OMPFirstprivateClause.class))  {
      for (/*const*/ Expr /*P*/ D : C.varlists$Const())  {
        FirstPrivateDecls.insert(cast_VarDecl(cast_DeclRefExpr(D).getDecl$Const()).getCanonicalDecl$Const());
      }
    }
  }

  
  /// \brief Generate all the base pointers, section pointers, sizes and map
  /// types for the extracted mappable expressions.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MappableExprsHandler::generateAllInfo">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 5386,
   FQN="(anonymous namespace)::MappableExprsHandler::generateAllInfo", NM="_ZNK12_GLOBAL__N_120MappableExprsHandler15generateAllInfoERN4llvm11SmallVectorIPNS1_5ValueELj16EEES6_S6_RNS2_IjLj16EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZNK12_GLOBAL__N_120MappableExprsHandler15generateAllInfoERN4llvm11SmallVectorIPNS1_5ValueELj16EEES6_S6_RNS2_IjLj16EEE")
  //</editor-fold>
  public void generateAllInfo(final SmallVector<Value /*P*/ > /*&*/ BasePointers, 
                 final SmallVector<Value /*P*/ > /*&*/ Pointers, final SmallVector<Value /*P*/ > /*&*/ Sizes, 
                 final SmallVectorUInt /*&*/ Types) /*const*/ {
    
    //<editor-fold defaultstate="collapsed" desc="MapInfo">
    @Converted(kind = Converted.Kind.AUTO,
            source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 5394,
            FQN = "MapInfo", NM = "_ZZNK12_GLOBAL__N_120MappableExprsHandler15generateAllInfoERN4llvm11SmallVectorIPNS1_5ValueELj16EEES6_S6_RNS2_IjLj16EEEE7MapInfo",
            cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZZNK12_GLOBAL__N_120MappableExprsHandler15generateAllInfoERN4llvm11SmallVectorIPNS1_5ValueELj16EEES6_S6_RNS2_IjLj16EEEE7MapInfo")
    //</editor-fold>
    class/*struct*/ MapInfo {
      public ArrayRef<OMPClauseMappableExprCommon.MappableComponent> Components;
      public OpenMPMapClauseKind MapType;
      public OpenMPMapClauseKind MapTypeModifier;
      //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MappableExprsHandler::generateAllInfo(MapValuesArrayTy & , MapValuesArrayTy & , MapValuesArrayTy & , MapFlagsArrayTy & )::MapInfo::operator=">

      @Converted(kind = Converted.Kind.MANUAL)
      public MapInfo(ArrayRef<OMPClauseMappableExprCommon.MappableComponent> Components, OpenMPMapClauseKind MapType, OpenMPMapClauseKind MapTypeModifier) {
        this.Components = Components;
        this.MapType = MapType;
        this.MapTypeModifier = MapTypeModifier;
      }
      
      @Converted(kind = Converted.Kind.AUTO,
              source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 5394,
              FQN = "(anonymous namespace)::MappableExprsHandler::generateAllInfo(MapValuesArrayTy & , MapValuesArrayTy & , MapValuesArrayTy & , MapFlagsArrayTy & )::MapInfo::operator=", NM = "_ZZNK12_GLOBAL__N_120MappableExprsHandler15generateAllInfoERN4llvm11SmallVectorIPNS1_5ValueELj16EEES6_S6_RNS2_IjLj16EEEEN7MapInfoaSEOS9_",
              cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZZNK12_GLOBAL__N_120MappableExprsHandler15generateAllInfoERN4llvm11SmallVectorIPNS1_5ValueELj16EEES6_S6_RNS2_IjLj16EEEEN7MapInfoaSEOS9_")
      //</editor-fold>
      public /*inline*/ MapInfo /*&*/ $assignMove(final MapInfo /*&&*/ $Prm0) {
        this.Components.$assignMove($Prm0.Components);
        this.MapType = $Prm0.MapType;
        this.MapTypeModifier = $Prm0.MapTypeModifier;
        return /*Deref*/ this;
      }

      @Override
      public String toString() {
        return "" + "Components=" + Components // NOI18N
                + ", MapType=" + MapType // NOI18N
                + ", MapTypeModifier=" + MapTypeModifier; // NOI18N
      }
    }

    // We have to process the component lists that relate with the same
    // declaration in a single chunk so that we can generate the map flags
    // correctly. Therefore, we organize all lists in a map.
    final DenseMap</*const*/ ValueDecl /*P*/ , SmallVector<MapInfo>> Info/*J*/= new DenseMap</*const*/ ValueDecl /*P*/ , SmallVector<MapInfo>>(DenseMapInfo$LikePtr.$Info(), new SmallVector<MapInfo>(8));
    try {
      BasePointers.clear();
      Pointers.clear();
      Sizes.clear();
      Types.clear();
            
      // Helper function to fill the information map for the different supported
      // clauses.
      final ValueDeclArrayRefEtc2Void InfoGen /*const*/ = /*[&Info]*/ (/*const*/ ValueDecl /*P*/ D, ArrayRef<OMPClauseMappableExprCommon.MappableComponent> L, OpenMPMapClauseKind MapType, OpenMPMapClauseKind MapModifier) -> {
            /*const*/ ValueDecl /*P*/ VD = (D != null) ? cast_ValueDecl(D.getCanonicalDecl$Const()) : null;
            Info.$at_T1$C$R(VD).push_back(new MapInfo(L, MapType, MapModifier));
          };
      
      for (/*const*/ OMPMapClause /*P*/ C : Directive.<OMPMapClause>getClausesOfKind(OMPMapClause.class))  {
        for (std.pair</*const*/ ValueDecl /*P*/ , ArrayRef<OMPClauseMappableExprCommon.MappableComponent> > L : C.component_lists())  {
          InfoGen.$call(L.first, /*NO_COPY*/L.second, C.getMapType(), C.getMapTypeModifier());
        }
      }
      for (/*const*/ OMPToClause /*P*/ C : Directive.<OMPToClause>getClausesOfKind(OMPToClause.class))  {
        for (std.pair</*const*/ ValueDecl /*P*/ , ArrayRef<OMPClauseMappableExprCommon.MappableComponent> > L : C.component_lists())  {
          InfoGen.$call(L.first, /*NO_COPY*/L.second, /*KEEP_ENUM*/OpenMPMapClauseKind.OMPC_MAP_to, /*KEEP_ENUM*/OpenMPMapClauseKind.OMPC_MAP_unknown);
        }
      }
      for (/*const*/ OMPFromClause /*P*/ C : Directive.<OMPFromClause>getClausesOfKind(OMPFromClause.class))  {
        for (std.pair</*const*/ ValueDecl /*P*/ , ArrayRef<OMPClauseMappableExprCommon.MappableComponent> > L : C.component_lists())  {
          InfoGen.$call(L.first, /*NO_COPY*/L.second, /*KEEP_ENUM*/OpenMPMapClauseKind.OMPC_MAP_from, /*KEEP_ENUM*/OpenMPMapClauseKind.OMPC_MAP_unknown);
        }
      }
      
      for (final std.pair</*const*/ ValueDecl /*P*/ , SmallVector<MapInfo>> /*&*/ M : Info) {
        // We need to know when we generate information for the first component
        // associated with a capture, because the mapping flags depend on it.
        boolean IsFirstComponentList = true;
        for (final MapInfo /*&*/ L : M.second) {
          assert (!L.Components.empty()) : "Not expecting declaration with no component lists.";
          generateInfoForComponentList(L.MapType, L.MapTypeModifier, new ArrayRef<OMPClauseMappableExprCommon.MappableComponent>(L.Components), 
              BasePointers, Pointers, Sizes, Types, 
              IsFirstComponentList);
          IsFirstComponentList = false;
        }
      }
    } finally {
      if (Info != null) { Info.$destroy(); }
    }
  }

  
  /// \brief Generate the base pointers, section pointers, sizes and map types
  /// associated to a given capture.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MappableExprsHandler::generateInfoForCapture">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 5443,
   FQN="(anonymous namespace)::MappableExprsHandler::generateInfoForCapture", NM="_ZNK12_GLOBAL__N_120MappableExprsHandler22generateInfoForCaptureEPKN5clang12CapturedStmt7CaptureERN4llvm11SmallVectorIPNS6_5ValueELj16EEESB_SB_RNS7_IjLj16EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZNK12_GLOBAL__N_120MappableExprsHandler22generateInfoForCaptureEPKN5clang12CapturedStmt7CaptureERN4llvm11SmallVectorIPNS6_5ValueELj16EEESB_SB_RNS7_IjLj16EEE")
  //</editor-fold>
  public void generateInfoForCapture(/*const*/ CapturedStmt.Capture /*P*/ Cap, 
                        final SmallVector<Value /*P*/ > /*&*/ BasePointers, 
                        final SmallVector<Value /*P*/ > /*&*/ Pointers, 
                        final SmallVector<Value /*P*/ > /*&*/ Sizes, 
                        final SmallVectorUInt /*&*/ Types) /*const*/ {
    assert (!Cap.capturesVariableArrayType()) : "Not expecting to generate map info for a variable array type!";
    
    BasePointers.clear();
    Pointers.clear();
    Sizes.clear();
    Types.clear();
    
    /*const*/ ValueDecl /*P*/ VD = Cap.capturesThis() ? null : cast_ValueDecl(Cap.getCapturedVar().getCanonicalDecl());
    
    // We need to know when we generating information for the first component
    // associated with a capture, because the mapping flags depend on it.
    boolean IsFirstComponentList = true;
    for (/*const*/ OMPMapClause /*P*/ C : Directive.<OMPMapClause>getClausesOfKind(OMPMapClause.class))  {
      for (std.pair</*const*/ ValueDecl /*P*/ , ArrayRef<OMPClauseMappableExprCommon.MappableComponent> > L : C.decl_component_lists(VD)) {
        assert (L.first == VD) : "We got information for the wrong declaration??";
        assert (!L.second.empty()) : "Not expecting declaration with no component lists.";
        generateInfoForComponentList(C.getMapType(), C.getMapTypeModifier(), 
            new ArrayRef<OMPClauseMappableExprCommon.MappableComponent>(L.second), BasePointers, Pointers, Sizes, 
            Types, IsFirstComponentList);
        IsFirstComponentList = false;
      }
    }
    
    return;
  }

  
  /// \brief Generate the default map information for a given capture \a CI,
  /// record field declaration \a RI and captured value \a CV.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MappableExprsHandler::generateDefaultMapInfo">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 5481,
   FQN="(anonymous namespace)::MappableExprsHandler::generateDefaultMapInfo", NM="_ZN12_GLOBAL__N_120MappableExprsHandler22generateDefaultMapInfoERKN5clang12CapturedStmt7CaptureERKNS1_9FieldDeclEPN4llvm5ValueERNS9_11SmallVectorISB_Lj16EEESE_SE_RNSC_IjLj16EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN12_GLOBAL__N_120MappableExprsHandler22generateDefaultMapInfoERKN5clang12CapturedStmt7CaptureERKNS1_9FieldDeclEPN4llvm5ValueERNS9_11SmallVectorISB_Lj16EEESE_SE_RNSC_IjLj16EEE")
  //</editor-fold>
  public void generateDefaultMapInfo(final /*const*/ CapturedStmt.Capture /*&*/ CI, final /*const*/ FieldDecl /*&*/ RI, Value /*P*/ CV, 
                        final SmallVector<Value /*P*/ > /*&*/ CurBasePointers, 
                        final SmallVector<Value /*P*/ > /*&*/ CurPointers, 
                        final SmallVector<Value /*P*/ > /*&*/ CurSizes, 
                        final SmallVectorUInt /*&*/ CurMapTypes) {
    
    // Do the default mapping.
    if (CI.capturesThis()) {
      CurBasePointers.push_back(CV);
      CurPointers.push_back(CV);
      /*const*/ org.clang.ast.PointerType /*P*/ PtrTy = AstTypesRTTI.cast_PointerType(RI.getType().getTypePtr());
      CurSizes.push_back(CGF.getTypeSize(PtrTy.getPointeeType()));
      // Default map type.
      CurMapTypes.push_back(MappableExprsHandler.OpenMPOffloadMappingFlags.OMP_MAP_TO
             | MappableExprsHandler.OpenMPOffloadMappingFlags.OMP_MAP_FROM);
    } else if (CI.capturesVariableByCopy()) {
      CurBasePointers.push_back(CV);
      CurPointers.push_back(CV);
      if (!RI.getType().$arrow().isAnyPointerType()) {
        // We have to signal to the runtime captures passed by value that are
        // not pointers.
        CurMapTypes.push_back(MappableExprsHandler.OpenMPOffloadMappingFlags.OMP_MAP_PRIVATE_VAL);
        CurSizes.push_back(CGF.getTypeSize(RI.getType()));
      } else {
        // Pointers are implicitly mapped with a zero size and no flags
        // (other than first map that is added for all implicit maps).
        CurMapTypes.push_back(0/*U*/);
        CurSizes.push_back(Constant.getNullValue(CGF.Unnamed_field8.SizeTy));
      }
    } else {
      assert (CI.capturesVariable()) : "Expected captured reference.";
      CurBasePointers.push_back(CV);
      CurPointers.push_back(CV);
      
      /*const*/ ReferenceType /*P*/ PtrTy = AstTypesRTTI.cast_ReferenceType(RI.getType().getTypePtr());
      QualType ElementType = PtrTy.getPointeeType();
      CurSizes.push_back(CGF.getTypeSize(new QualType(ElementType)));
      // The default map type for a scalar/complex type is 'to' because by
      // default the value doesn't have to be retrieved. For an aggregate
      // type, the default is 'tofrom'.
      CurMapTypes.push_back(ElementType.$arrow().isAggregateType() ? (MappableExprsHandler.OpenMPOffloadMappingFlags.OMP_MAP_TO
             | MappableExprsHandler.OpenMPOffloadMappingFlags.OMP_MAP_FROM) : MappableExprsHandler.OpenMPOffloadMappingFlags.OMP_MAP_TO);
      
      // If we have a capture by reference we may need to add the private
      // pointer flag if the base declaration shows in some first-private
      // clause.
      CurMapTypes.ref$back()
         .$set(adjustMapModifiersForPrivateClauses(CI, CurMapTypes.back()));
    }
    // Every default map produces a single argument, so, it is always the
    // first one.
    CurMapTypes.ref$back().$set$orassign(MappableExprsHandler.OpenMPOffloadMappingFlags.OMP_MAP_FIRST_REF);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MappableExprsHandler::~MappableExprsHandler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp", line = 4961,
   FQN="(anonymous namespace)::MappableExprsHandler::~MappableExprsHandler", NM="_ZN12_GLOBAL__N_120MappableExprsHandlerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=_ZN12_GLOBAL__N_120MappableExprsHandlerD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    FirstPrivateDecls.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "Directive=" + Directive // NOI18N
              + ", CGF=" + CGF // NOI18N
              + ", FirstPrivateDecls=" + "[SmallPtrSet$VarDecl]"; // NOI18N
  }
}
