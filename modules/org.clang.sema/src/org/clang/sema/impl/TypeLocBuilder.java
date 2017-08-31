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

package org.clang.sema.impl;

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import static org.clang.ast.QualType.*;
import org.clank.java.std;

//<editor-fold defaultstate="collapsed" desc="clang::TypeLocBuilder">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TypeLocBuilder.h", line = 23,
 FQN="clang::TypeLocBuilder", NM="_ZN5clang14TypeLocBuilderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/TypeLocBuilder.cpp -nm=_ZN5clang14TypeLocBuilderE")
//</editor-fold>
public class TypeLocBuilder implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocBuilder::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TypeLocBuilder.h", line = 24,
   FQN="clang::TypeLocBuilder::(anonymous)", NM="_ZN5clang14TypeLocBuilderE_Unnamed_enum",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/TypeLocBuilder.cpp -nm=_ZN5clang14TypeLocBuilderE_Unnamed_enum")
  //</editor-fold>
  /*enum ANONYMOUS_INT_CONSTANTS {*/
    public static final /*uint*/int InlineCapacity = 8 * SourceLocation.$sizeof_SourceLocation();
  /*}*/;
  
  /// The underlying location-data buffer.  Data grows from the end
  /// of the buffer backwards.
  private type$ptr<?>/*char P*/ Buffer;
  
  /// The capacity of the current buffer.
  private /*size_t*/int Capacity;
  
  /// The index of the first occupied byte in the buffer.
  private /*size_t*/int Index;
  /// The last type pushed on this builder.
  private QualType LastTy;
  
  /// The inline buffer.
  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocBuilder::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TypeLocBuilder.h", line = 42,
   FQN="clang::TypeLocBuilder::(anonymous)", NM="_ZN5clang14TypeLocBuilderE_Unnamed_enum1",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/TypeLocBuilder.cpp -nm=_ZN5clang14TypeLocBuilderE_Unnamed_enum1")
  //</editor-fold>
  /*enum ANONYMOUS_INT_CONSTANTS {*/
    public static final /*uint*/int BufferMaxAlignment = alignOf(Object.class);
  /*}*/;
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*inline buffer*/)
  private final AlignedJavaArray InlineBuffer = new AlignedJavaArray(InlineCapacity); // JAVA: changed to array of references
  private /*uint*/int NumBytesAtAlign4;
  private /*uint*/int NumBytesAtAlign8;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocBuilder::TypeLocBuilder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TypeLocBuilder.h", line = 47,
   FQN="clang::TypeLocBuilder::TypeLocBuilder", NM="_ZN5clang14TypeLocBuilderC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/TypeLocBuilder.cpp -nm=_ZN5clang14TypeLocBuilderC1Ev")
  //</editor-fold>
  public TypeLocBuilder() {
    // : Buffer(InlineBuffer.buffer), Capacity(InlineCapacity), Index(InlineCapacity), LastTy(), InlineBuffer(), NumBytesAtAlign4(0), NumBytesAtAlign8(0) 
    //START JInit
    this.Buffer = $tryClone(InlineBuffer.buffer);
    this.Capacity = InlineCapacity;
    this.Index = InlineCapacity;
    this.LastTy = new QualType();
    this.NumBytesAtAlign4 = 0;
    this.NumBytesAtAlign8 = 0;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocBuilder::~TypeLocBuilder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TypeLocBuilder.h", line = 53,
   FQN="clang::TypeLocBuilder::~TypeLocBuilder", NM="_ZN5clang14TypeLocBuilderD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/TypeLocBuilder.cpp -nm=_ZN5clang14TypeLocBuilderD0Ev")
  //</editor-fold>
  public void $destroy() {
    if ($noteq_ptr(Buffer, InlineBuffer.buffer)) {
      /*delete[]*/Destructors.$destroyArray(Buffer);
    }
  }

  
  /// Ensures that this buffer has at least as much capacity as described.
  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocBuilder::reserve">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TypeLocBuilder.h", line = 59,
   FQN="clang::TypeLocBuilder::reserve", NM="_ZN5clang14TypeLocBuilder7reserveEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/TypeLocBuilder.cpp -nm=_ZN5clang14TypeLocBuilder7reserveEj")
  //</editor-fold>
  public void reserve(/*size_t*/int Requested) {
    if ($greater_uint(Requested, Capacity)) {
      // For now, match the request exactly.
      grow(Requested);
    }
  }

  
  /// Pushes a copy of the given TypeLoc onto this builder.  The builder
  /// must be empty for this to work.
  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocBuilder::pushFullCopy">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TypeLocBuilder.cpp", line = 19,
   FQN="clang::TypeLocBuilder::pushFullCopy", NM="_ZN5clang14TypeLocBuilder12pushFullCopyENS_7TypeLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/TypeLocBuilder.cpp -nm=_ZN5clang14TypeLocBuilder12pushFullCopyENS_7TypeLocE")
  //</editor-fold>
  public void pushFullCopy(TypeLoc L) {
    /*size_t*/int Size = L.getFullDataSize();
    reserve(Size);
    
    SmallVector<TypeLoc> TypeLocs/*J*/= new SmallVector<TypeLoc>(4, new TypeLoc());
    TypeLoc CurTL = new TypeLoc(L);
    while (CurTL.$bool()) {
      TypeLocs.push_back(CurTL);
      CurTL.$assignMove(CurTL.getNextTypeLoc());
    }
    
    for (/*uint*/int i = 0, e = TypeLocs.size(); $less_uint(i, e); ++i) {
      TypeLoc CurTL$1 = new TypeLoc(TypeLocs.$at(e - i - 1));
      switch (CurTL$1.getTypeLocClass()) {
       case Qualified:
        {
          QualifiedTypeLoc NewTL = push(QualifiedTypeLoc.class, CurTL$1.getType());
          memcpy(NewTL.getOpaqueData(), CurTL$1.getOpaqueData(), NewTL.getLocalDataSize());
          break;
        }
       case Builtin:
        {
          BuiltinTypeLoc NewTL = push(BuiltinTypeLoc.class, CurTL$1.getType());
          memcpy(NewTL.getOpaqueData(), CurTL$1.getOpaqueData(), NewTL.getLocalDataSize());
          break;
        }
       case Complex:
        {
          ComplexTypeLoc NewTL = push(ComplexTypeLoc.class, CurTL$1.getType());
          memcpy(NewTL.getOpaqueData(), CurTL$1.getOpaqueData(), NewTL.getLocalDataSize());
          break;
        }
       case Pointer:
        {
          PointerTypeLoc NewTL = push(PointerTypeLoc.class, CurTL$1.getType());
          memcpy(NewTL.getOpaqueData(), CurTL$1.getOpaqueData(), NewTL.getLocalDataSize());
          break;
        }
       case BlockPointer:
        {
          BlockPointerTypeLoc NewTL = push(BlockPointerTypeLoc.class, CurTL$1.getType());
          memcpy(NewTL.getOpaqueData(), CurTL$1.getOpaqueData(), NewTL.getLocalDataSize());
          break;
        }
       case LValueReference:
        {
          LValueReferenceTypeLoc NewTL = push(LValueReferenceTypeLoc.class, CurTL$1.getType());
          memcpy(NewTL.getOpaqueData(), CurTL$1.getOpaqueData(), NewTL.getLocalDataSize());
          break;
        }
       case RValueReference:
        {
          RValueReferenceTypeLoc NewTL = push(RValueReferenceTypeLoc.class, CurTL$1.getType());
          memcpy(NewTL.getOpaqueData(), CurTL$1.getOpaqueData(), NewTL.getLocalDataSize());
          break;
        }
       case MemberPointer:
        {
          MemberPointerTypeLoc NewTL = push(MemberPointerTypeLoc.class, CurTL$1.getType());
          memcpy(NewTL.getOpaqueData(), CurTL$1.getOpaqueData(), NewTL.getLocalDataSize());
          break;
        }
       case ConstantArray:
        {
          ConstantArrayTypeLoc NewTL = push(ConstantArrayTypeLoc.class, CurTL$1.getType());
          memcpy(NewTL.getOpaqueData(), CurTL$1.getOpaqueData(), NewTL.getLocalDataSize());
          break;
        }
       case IncompleteArray:
        {
          IncompleteArrayTypeLoc NewTL = push(IncompleteArrayTypeLoc.class, CurTL$1.getType());
          memcpy(NewTL.getOpaqueData(), CurTL$1.getOpaqueData(), NewTL.getLocalDataSize());
          break;
        }
       case VariableArray:
        {
          VariableArrayTypeLoc NewTL = push(VariableArrayTypeLoc.class, CurTL$1.getType());
          memcpy(NewTL.getOpaqueData(), CurTL$1.getOpaqueData(), NewTL.getLocalDataSize());
          break;
        }
       case DependentSizedArray:
        {
          DependentSizedArrayTypeLoc NewTL = push(DependentSizedArrayTypeLoc.class, CurTL$1.getType());
          memcpy(NewTL.getOpaqueData(), CurTL$1.getOpaqueData(), NewTL.getLocalDataSize());
          break;
        }
       case DependentSizedExtVector:
        {
          DependentSizedExtVectorTypeLoc NewTL = push(DependentSizedExtVectorTypeLoc.class, CurTL$1.getType());
          memcpy(NewTL.getOpaqueData(), CurTL$1.getOpaqueData(), NewTL.getLocalDataSize());
          break;
        }
       case Vector:
        {
          VectorTypeLoc NewTL = push(VectorTypeLoc.class, CurTL$1.getType());
          memcpy(NewTL.getOpaqueData(), CurTL$1.getOpaqueData(), NewTL.getLocalDataSize());
          break;
        }
       case ExtVector:
        {
          ExtVectorTypeLoc NewTL = push(ExtVectorTypeLoc.class, CurTL$1.getType());
          memcpy(NewTL.getOpaqueData(), CurTL$1.getOpaqueData(), NewTL.getLocalDataSize());
          break;
        }
       case FunctionProto:
        {
          FunctionProtoTypeLoc NewTL = push(FunctionProtoTypeLoc.class, CurTL$1.getType());
          memcpy(NewTL.getOpaqueData(), CurTL$1.getOpaqueData(), NewTL.getLocalDataSize());
          break;
        }
       case FunctionNoProto:
        {
          FunctionNoProtoTypeLoc NewTL = push(FunctionNoProtoTypeLoc.class, CurTL$1.getType());
          memcpy(NewTL.getOpaqueData(), CurTL$1.getOpaqueData(), NewTL.getLocalDataSize());
          break;
        }
       case UnresolvedUsing:
        {
          UnresolvedUsingTypeLoc NewTL = push(UnresolvedUsingTypeLoc.class, CurTL$1.getType());
          memcpy(NewTL.getOpaqueData(), CurTL$1.getOpaqueData(), NewTL.getLocalDataSize());
          break;
        }
       case Paren:
        {
          ParenTypeLoc NewTL = push(ParenTypeLoc.class, CurTL$1.getType());
          memcpy(NewTL.getOpaqueData(), CurTL$1.getOpaqueData(), NewTL.getLocalDataSize());
          break;
        }
       case Typedef:
        {
          TypedefTypeLoc NewTL = push(TypedefTypeLoc.class, CurTL$1.getType());
          memcpy(NewTL.getOpaqueData(), CurTL$1.getOpaqueData(), NewTL.getLocalDataSize());
          break;
        }
       case Adjusted:
        {
          AdjustedTypeLoc NewTL = push(AdjustedTypeLoc.class, CurTL$1.getType());
          memcpy(NewTL.getOpaqueData(), CurTL$1.getOpaqueData(), NewTL.getLocalDataSize());
          break;
        }
       case Decayed:
        {
          DecayedTypeLoc NewTL = push(DecayedTypeLoc.class, CurTL$1.getType());
          memcpy(NewTL.getOpaqueData(), CurTL$1.getOpaqueData(), NewTL.getLocalDataSize());
          break;
        }
       case TypeOfExpr:
        {
          TypeOfExprTypeLoc NewTL = push(TypeOfExprTypeLoc.class, CurTL$1.getType());
          memcpy(NewTL.getOpaqueData(), CurTL$1.getOpaqueData(), NewTL.getLocalDataSize());
          break;
        }
       case TypeOf:
        {
          TypeOfTypeLoc NewTL = push(TypeOfTypeLoc.class, CurTL$1.getType());
          memcpy(NewTL.getOpaqueData(), CurTL$1.getOpaqueData(), NewTL.getLocalDataSize());
          break;
        }
       case Decltype:
        {
          DecltypeTypeLoc NewTL = push(DecltypeTypeLoc.class, CurTL$1.getType());
          memcpy(NewTL.getOpaqueData(), CurTL$1.getOpaqueData(), NewTL.getLocalDataSize());
          break;
        }
       case UnaryTransform:
        {
          UnaryTransformTypeLoc NewTL = push(UnaryTransformTypeLoc.class, CurTL$1.getType());
          memcpy(NewTL.getOpaqueData(), CurTL$1.getOpaqueData(), NewTL.getLocalDataSize());
          break;
        }
       case Record:
        {
          RecordTypeLoc NewTL = push(RecordTypeLoc.class, CurTL$1.getType());
          memcpy(NewTL.getOpaqueData(), CurTL$1.getOpaqueData(), NewTL.getLocalDataSize());
          break;
        }
       case Enum:
        {
          EnumTypeLoc NewTL = push(EnumTypeLoc.class, CurTL$1.getType());
          memcpy(NewTL.getOpaqueData(), CurTL$1.getOpaqueData(), NewTL.getLocalDataSize());
          break;
        }
       case Elaborated:
        {
          ElaboratedTypeLoc NewTL = push(ElaboratedTypeLoc.class, CurTL$1.getType());
          memcpy(NewTL.getOpaqueData(), CurTL$1.getOpaqueData(), NewTL.getLocalDataSize());
          break;
        }
       case Attributed:
        {
          AttributedTypeLoc NewTL = push(AttributedTypeLoc.class, CurTL$1.getType());
          memcpy(NewTL.getOpaqueData(), CurTL$1.getOpaqueData(), NewTL.getLocalDataSize());
          break;
        }
       case TemplateTypeParm:
        {
          TemplateTypeParmTypeLoc NewTL = push(TemplateTypeParmTypeLoc.class, CurTL$1.getType());
          memcpy(NewTL.getOpaqueData(), CurTL$1.getOpaqueData(), NewTL.getLocalDataSize());
          break;
        }
       case SubstTemplateTypeParm:
        {
          SubstTemplateTypeParmTypeLoc NewTL = push(SubstTemplateTypeParmTypeLoc.class, CurTL$1.getType());
          memcpy(NewTL.getOpaqueData(), CurTL$1.getOpaqueData(), NewTL.getLocalDataSize());
          break;
        }
       case SubstTemplateTypeParmPack:
        {
          SubstTemplateTypeParmPackTypeLoc NewTL = push(SubstTemplateTypeParmPackTypeLoc.class, CurTL$1.getType());
          memcpy(NewTL.getOpaqueData(), CurTL$1.getOpaqueData(), NewTL.getLocalDataSize());
          break;
        }
       case TemplateSpecialization:
        {
          TemplateSpecializationTypeLoc NewTL = push(TemplateSpecializationTypeLoc.class, CurTL$1.getType());
          memcpy(NewTL.getOpaqueData(), CurTL$1.getOpaqueData(), NewTL.getLocalDataSize());
          break;
        }
       case Auto:
        {
          AutoTypeLoc NewTL = push(AutoTypeLoc.class, CurTL$1.getType());
          memcpy(NewTL.getOpaqueData(), CurTL$1.getOpaqueData(), NewTL.getLocalDataSize());
          break;
        }
       case InjectedClassName:
        {
          InjectedClassNameTypeLoc NewTL = push(InjectedClassNameTypeLoc.class, CurTL$1.getType());
          memcpy(NewTL.getOpaqueData(), CurTL$1.getOpaqueData(), NewTL.getLocalDataSize());
          break;
        }
       case DependentName:
        {
          DependentNameTypeLoc NewTL = push(DependentNameTypeLoc.class, CurTL$1.getType());
          memcpy(NewTL.getOpaqueData(), CurTL$1.getOpaqueData(), NewTL.getLocalDataSize());
          break;
        }
       case DependentTemplateSpecialization:
        {
          DependentTemplateSpecializationTypeLoc NewTL = push(DependentTemplateSpecializationTypeLoc.class, CurTL$1.getType());
          memcpy(NewTL.getOpaqueData(), CurTL$1.getOpaqueData(), NewTL.getLocalDataSize());
          break;
        }
       case PackExpansion:
        {
          PackExpansionTypeLoc NewTL = push(PackExpansionTypeLoc.class, CurTL$1.getType());
          memcpy(NewTL.getOpaqueData(), CurTL$1.getOpaqueData(), NewTL.getLocalDataSize());
          break;
        }
       case ObjCObject:
        {
          ObjCObjectTypeLoc NewTL = push(ObjCObjectTypeLoc.class, CurTL$1.getType());
          memcpy(NewTL.getOpaqueData(), CurTL$1.getOpaqueData(), NewTL.getLocalDataSize());
          break;
        }
       case ObjCInterface:
        {
          ObjCInterfaceTypeLoc NewTL = push(ObjCInterfaceTypeLoc.class, CurTL$1.getType());
          memcpy(NewTL.getOpaqueData(), CurTL$1.getOpaqueData(), NewTL.getLocalDataSize());
          break;
        }
       case ObjCObjectPointer:
        {
          ObjCObjectPointerTypeLoc NewTL = push(ObjCObjectPointerTypeLoc.class, CurTL$1.getType());
          memcpy(NewTL.getOpaqueData(), CurTL$1.getOpaqueData(), NewTL.getLocalDataSize());
          break;
        }
       case Pipe:
        {
          PipeTypeLoc NewTL = push(PipeTypeLoc.class, CurTL$1.getType());
          memcpy(NewTL.getOpaqueData(), CurTL$1.getOpaqueData(), NewTL.getLocalDataSize());
          break;
        }
       case Atomic:
        {
          AtomicTypeLoc NewTL = push(AtomicTypeLoc.class, CurTL$1.getType());
          memcpy(NewTL.getOpaqueData(), CurTL$1.getOpaqueData(), NewTL.getLocalDataSize());
          break;
        }
      }
    }
  }

  
  /// Pushes space for a typespec TypeLoc.  Invalidates any TypeLocs
  /// previously retrieved from this builder.
  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocBuilder::pushTypeSpec">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TypeLocBuilder.h", line = 71,
   FQN="clang::TypeLocBuilder::pushTypeSpec", NM="_ZN5clang14TypeLocBuilder12pushTypeSpecENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/TypeLocBuilder.cpp -nm=_ZN5clang14TypeLocBuilder12pushTypeSpecENS_8QualTypeE")
  //</editor-fold>
  public TypeSpecTypeLoc pushTypeSpec(QualType T) {
    /*size_t*/int LocalSize = TypeSpecTypeLoc.Unnamed_enum.LocalDataSize.getValue();
    /*uint*/int LocalAlign = TypeSpecTypeLoc.Unnamed_enum.LocalDataAlignment.getValue();
    return pushImpl(/*NO_COPY*/T, LocalSize, LocalAlign).castAs(TypeSpecTypeLoc.class);
  }

  
  /// Resets this builder to the newly-initialized state.
  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocBuilder::clear">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TypeLocBuilder.h", line = 78,
   FQN="clang::TypeLocBuilder::clear", NM="_ZN5clang14TypeLocBuilder5clearEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/TypeLocBuilder.cpp -nm=_ZN5clang14TypeLocBuilder5clearEv")
  //</editor-fold>
  public void clear() {
    LastTy.$assignMove(new QualType());
    Index = Capacity;
    NumBytesAtAlign4 = NumBytesAtAlign8 = 0;
  }

  
  /// \brief Tell the TypeLocBuilder that the type it is storing has been
  /// modified in some safe way that doesn't affect type-location information.
  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocBuilder::TypeWasModifiedSafely">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TypeLocBuilder.h", line = 88,
   FQN="clang::TypeLocBuilder::TypeWasModifiedSafely", NM="_ZN5clang14TypeLocBuilder21TypeWasModifiedSafelyENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/TypeLocBuilder.cpp -nm=_ZN5clang14TypeLocBuilder21TypeWasModifiedSafelyENS_8QualTypeE")
  //</editor-fold>
  public void TypeWasModifiedSafely(QualType T) {
    LastTy.$assign(T);
  }
  

  /// Pushes space for a new TypeLoc of the given type.  Invalidates
  /// any TypeLocs previously retrieved from this builder.  
  /*template <class TyLocType> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocBuilder::push">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TypeLocBuilder.h", line = 96,
   FQN="clang::TypeLocBuilder::push", NM="Tpl__ZN5clang14TypeLocBuilder4pushENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/TypeLocBuilder.cpp -nm=Tpl__ZN5clang14TypeLocBuilder4pushENS_8QualTypeE")
  //</editor-fold>  
  public <TyLocType extends TypeLoc> TyLocType push(Class<? extends TyLocType> clazz, QualType qt) {
    TypeLoc Loc = new TypeLoc(/*NO_COPY*/qt, (type$ptr<?>/*void P*/ )null).castAs(clazz);
    /*size_t*/int LocalSize = Loc.getLocalDataSize();
    /*uint*/int LocalAlign = Loc.getLocalDataAlignment();
    return (TyLocType)pushImpl(/*NO_COPY*/qt, LocalSize, LocalAlign).castAs(clazz);
  }

  
  /// Creates a TypeSourceInfo for the given type.
  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocBuilder::getTypeSourceInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TypeLocBuilder.h", line = 104,
   FQN="clang::TypeLocBuilder::getTypeSourceInfo", NM="_ZN5clang14TypeLocBuilder17getTypeSourceInfoERNS_10ASTContextENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/TypeLocBuilder.cpp -nm=_ZN5clang14TypeLocBuilder17getTypeSourceInfoERNS_10ASTContextENS_8QualTypeE")
  //</editor-fold>
  public TypeSourceInfo /*P*/ getTypeSourceInfo(final ASTContext /*&*/ Context, QualType T) {
    assert ($eq_QualType$C(T, LastTy)) : "type doesn't match last type pushed!";
    
    /*size_t*/int FullDataSize = Capacity - Index;
    TypeSourceInfo /*P*/ DI = Context.CreateTypeSourceInfo(new QualType(T), FullDataSize);
    memcpy(DI.getTypeLoc().getOpaqueData(), Buffer.$add(Index), FullDataSize);
    return DI;
  }

  
  /// \brief Copies the type-location information to the given AST context and 
  /// returns a \c TypeLoc referring into the AST context.
  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocBuilder::getTypeLocInContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TypeLocBuilder.h", line = 117,
   FQN="clang::TypeLocBuilder::getTypeLocInContext", NM="_ZN5clang14TypeLocBuilder19getTypeLocInContextERNS_10ASTContextENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/TypeLocBuilder.cpp -nm=_ZN5clang14TypeLocBuilder19getTypeLocInContextERNS_10ASTContextENS_8QualTypeE")
  //</editor-fold>
  public TypeLoc getTypeLocInContext(final ASTContext /*&*/ Context, QualType T) {
    assert ($eq_QualType$C(T, LastTy)) : "type doesn't match last type pushed!";
    
    /*size_t*/int FullDataSize = Capacity - Index;
    type$ptr<?>/*void P*/ Mem = Context.Allocate$JavaRef(FullDataSize);
    memcpy(Mem, Buffer.$add(Index), FullDataSize);
    return new TypeLoc(new QualType(T), Mem);
  }

/*private:*/
  
  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocBuilder::pushImpl">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TypeLocBuilder.cpp", line = 63,
   FQN="clang::TypeLocBuilder::pushImpl", NM="_ZN5clang14TypeLocBuilder8pushImplENS_8QualTypeEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/TypeLocBuilder.cpp -nm=_ZN5clang14TypeLocBuilder8pushImplENS_8QualTypeEjj")
  //</editor-fold>
  private TypeLoc pushImpl(QualType T, /*size_t*/int LocalSize, /*uint*/int LocalAlignment) {
    QualType TLast = new TypeLoc(new QualType(T), (type$ptr<?>/*void P*/ )null).getNextTypeLoc().getType();
    assert ($eq_QualType$C(TLast, LastTy)) : "mismatch between last type and new type's inner type";
    LastTy.$assign(T);
    assert ($lesseq_uint(LocalAlignment, BufferMaxAlignment)) : "Unexpected alignment";
    
    // If we need to grow, grow by a factor of 2.
    if ($greater_uint(LocalSize, Index)) {
      /*size_t*/int RequiredCapacity = Capacity + (LocalSize - Index);
      /*size_t*/int NewCapacity = Capacity * 2;
      while ($greater_uint(RequiredCapacity, NewCapacity)) {
        NewCapacity *= 2;
      }
      grow(NewCapacity);
    }
    
    // Because we're adding elements to the TypeLoc backwards, we have to
    // do some extra work to keep everything aligned appropriately.
    // FIXME: This algorithm is a absolute mess because every TypeLoc returned
    // needs to be valid.  Partial TypeLocs are a terrible idea.
    // FIXME: 4 and 8 are sufficient at the moment, but it's pretty ugly to
    // hardcode them.
    if (LocalAlignment == 4) {
      if (NumBytesAtAlign8 == 0) {
        NumBytesAtAlign4 += LocalSize;
      } else {
        /*uint*/int Padding = $rem_uint(NumBytesAtAlign4, 8);
        if (Padding == 0) {
          if ($rem_uint(LocalSize, 8) == 0) {
            // Everything is set: there's no padding and we don't need to add
            // any.
          } else {
            assert ($rem_uint(LocalSize, 8) == 4);
            // No existing padding; add in 4 bytes padding
            memmove(Buffer.$add(Index - 4), Buffer.$add(Index), NumBytesAtAlign4);
            Index -= 4;
          }
        } else {
          assert (Padding == 4);
          if ($rem_uint(LocalSize, 8) == 0) {
            // Everything is set: there's 4 bytes padding and we don't need
            // to add any.
          } else {
            assert ($rem_uint(LocalSize, 8) == 4);
            // There are 4 bytes padding, but we don't need any; remove it.
            memmove(Buffer.$add(Index + 4), Buffer.$add(Index), NumBytesAtAlign4);
            Index += 4;
          }
        }
        NumBytesAtAlign4 += LocalSize;
      }
    } else if (LocalAlignment == 8) {
      if (NumBytesAtAlign8 == 0) {
        // We have not seen any 8-byte aligned element yet. We insert a padding
        // only if the new Index is not 8-byte-aligned.
        if ($rem_uint((Index - LocalSize), 8) != 0) {
          memmove(Buffer.$add(Index - 4), Buffer.$add(Index), NumBytesAtAlign4);
          Index -= 4;
        }
      } else {
        /*uint*/int Padding = $rem_uint(NumBytesAtAlign4, 8);
        if (Padding == 0) {
          if ($rem_uint(LocalSize, 8) == 0) {
            // Everything is set: there's no padding and we don't need to add
            // any.
          } else {
            assert ($rem_uint(LocalSize, 8) == 4);
            // No existing padding; add in 4 bytes padding
            memmove(Buffer.$add(Index - 4), Buffer.$add(Index), NumBytesAtAlign4);
            Index -= 4;
          }
        } else {
          assert (Padding == 4);
          if ($rem_uint(LocalSize, 8) == 0) {
            // Everything is set: there's 4 bytes padding and we don't need
            // to add any.
          } else {
            assert ($rem_uint(LocalSize, 8) == 4);
            // There are 4 bytes padding, but we don't need any; remove it.
            memmove(Buffer.$add(Index + 4), Buffer.$add(Index), NumBytesAtAlign4);
            Index += 4;
          }
        }
      }
      
      // Forget about any padding.
      NumBytesAtAlign4 = 0;
      NumBytesAtAlign8 += LocalSize;
    } else {
      // JAVA: MEMORY
      assert /*JAVA all alignments are 1*/(LocalAlignment == 1) || (LocalSize == 0);
    }
    
    Index -= LocalSize;
    assert (Capacity - Index == TypeLoc.getFullDataSizeForType(new QualType(T))) : "incorrect data size provided to CreateTypeSourceInfo!";
    
    return getTemporaryTypeLoc(new QualType(T), LocalSize);
  }

  
  /// Grow to the given capacity.
  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocBuilder::grow">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TypeLocBuilder.cpp", line = 45,
   FQN="clang::TypeLocBuilder::grow", NM="_ZN5clang14TypeLocBuilder4growEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/TypeLocBuilder.cpp -nm=_ZN5clang14TypeLocBuilder4growEj")
  //</editor-fold>
  private void grow(/*size_t*/int NewCapacity) {
    assert ($greater_uint(NewCapacity, Capacity));
    
    // Allocate the new buffer and copy the old data into it.
    type$ptr<?>/*char P*/ NewBuffer = create_type$ptr(new$T(new Object[NewCapacity], ()->null));
    /*uint*/int NewIndex = Index + NewCapacity - Capacity;
    memcpy(NewBuffer.$add(NewIndex), 
        Buffer.$add(Index), 
        Capacity - Index);
    if ($noteq_ptr(Buffer, InlineBuffer.buffer)) {
      /*delete[]*/Destructors.$destroyArray(Buffer);
    }
    
    Buffer = $tryClone(NewBuffer);
    Capacity = NewCapacity;
    Index = NewIndex;
  }

  
  /// \brief Retrieve a temporary TypeLoc that refers into this \c TypeLocBuilder
  /// object.
  ///
  /// The resulting \c TypeLoc should only be used so long as the 
  /// \c TypeLocBuilder is active and has not had more type information
  /// pushed into it.
  //<editor-fold defaultstate="collapsed" desc="clang::TypeLocBuilder::getTemporaryTypeLoc">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*PrepareMemory*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TypeLocBuilder.h", line = 141,
   FQN="clang::TypeLocBuilder::getTemporaryTypeLoc", NM="_ZN5clang14TypeLocBuilder19getTemporaryTypeLocENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/TypeLocBuilder.cpp -nm=_ZN5clang14TypeLocBuilder19getTemporaryTypeLocENS_8QualTypeE")
  //</editor-fold>
  private TypeLoc getTemporaryTypeLoc(QualType T, int InitializeTotalSize) {
    assert ($eq_QualType$C(LastTy, T)) : "type doesn't match last type pushed!";
    // JAVA: MEMORY: we need to prepare memory like in ASTContext::CreateTypeSourceInfo
    type$ptr<?> TypeLoc$Data = Buffer.$add(Index);
    TypeLoc.javaPrepareMemory(T, TypeLoc$Data, InitializeTotalSize);
    return new TypeLoc(new QualType(T), TypeLoc$Data);
  }

  /**
   * we interpose memcopy used in pushFullCopy to manipulate isPointerLike with minimal changes in code
   */
  private static void memcpy(type$ptr to, type$ptr from, /*size_t*/int size) {
    std.memcpy(to, from, size, TypeLoc.DATA_DEEP_COPY);
  }

  @Override public String toString() {
    return "" + "Buffer=" + Buffer // NOI18N
              + ", Capacity=" + Capacity // NOI18N
              + ", Index=" + Index // NOI18N
              + ", LastTy=" + LastTy // NOI18N
              + ", InlineBuffer=" + InlineBuffer // NOI18N
              + ", NumBytesAtAlign4=" + NumBytesAtAlign4 // NOI18N
              + ", NumBytesAtAlign8=" + NumBytesAtAlign8; // NOI18N
  }
}
