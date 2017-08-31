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

package org.llvm.linker.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.built_in.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.support.Error;
import org.llvm.ir.*;
import static org.llvm.ir.java.IrRTTI.*;
import org.llvm.linker.*;;
import org.llvm.linker.java.*;
import org.llvm.linker.java.LinkerFunctionPointers.*;
import org.llvm.linker.impl.*;
import static org.llvm.linker.impl.IRMoverStatics.*;
import org.llvm.llvmc.*;
import org.llvm.transforms.utils.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeMapTy">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp", line = 31,
 FQN="(anonymous namespace)::TypeMapTy", NM="_ZN12_GLOBAL__N_19TypeMapTyE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.linker/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp -nm=_ZN12_GLOBAL__N_19TypeMapTyE")
//</editor-fold>
public class TypeMapTy extends /*public*/ ValueMapTypeRemapper implements Destructors.ClassWithDestructor {
  /// This is a mapping from a source type to a destination type to use.
  private DenseMap<Type /*P*/ , Type /*P*/ > MappedTypes;
  
  /// When checking to see if two subgraphs are isomorphic, we speculatively
  /// add types to MappedTypes, but keep track of them here in case we need to
  /// roll back.
  private SmallVector<Type /*P*/ > SpeculativeTypes;
  
  private SmallVector<StructType /*P*/ > SpeculativeDstOpaqueTypes;
  
  /// This is a list of non-opaque structs in the source module that are mapped
  /// to an opaque struct in the destination module.
  private SmallVector<StructType /*P*/ > SrcDefinitionsToResolve;
  
  /// This is the set of opaque types in the destination modules who are
  /// getting a body from the source module.
  private SmallPtrSet<StructType /*P*/ > DstResolvedOpaqueTypes;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeMapTy::TypeMapTy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp", line = 51,
   FQN="(anonymous namespace)::TypeMapTy::TypeMapTy", NM="_ZN12_GLOBAL__N_19TypeMapTyC1ERN4llvm7IRMover23IdentifiedStructTypeSetE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.linker/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp -nm=_ZN12_GLOBAL__N_19TypeMapTyC1ERN4llvm7IRMover23IdentifiedStructTypeSetE")
  //</editor-fold>
  public TypeMapTy(final IRMover.IdentifiedStructTypeSet /*&*/ DstStructTypesSet) {
    // : ValueMapTypeRemapper(), MappedTypes(), SpeculativeTypes(), SpeculativeDstOpaqueTypes(), SrcDefinitionsToResolve(), DstResolvedOpaqueTypes(), DstStructTypesSet(DstStructTypesSet) 
    //START JInit
    super();
    this.MappedTypes = new DenseMap<Type /*P*/ , Type /*P*/ >(DenseMapInfo$LikePtr.$Info(), (Type /*P*/ )null);
    this.SpeculativeTypes = new SmallVector<Type /*P*/ >(16, (Type /*P*/ )null);
    this.SpeculativeDstOpaqueTypes = new SmallVector<StructType /*P*/ >(16, (StructType /*P*/ )null);
    this.SrcDefinitionsToResolve = new SmallVector<StructType /*P*/ >(16, (StructType /*P*/ )null);
    this.DstResolvedOpaqueTypes = new SmallPtrSet<StructType /*P*/ >(DenseMapInfo$LikePtr.$Info(), 16);
    this./*&*/DstStructTypesSet=/*&*/DstStructTypesSet;
    //END JInit
  }

  
  public final IRMover.IdentifiedStructTypeSet /*&*/ DstStructTypesSet;
  /// Indicate that the specified type in the destination module is conceptually
  /// equivalent to the specified type in the source module.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeMapTy::addTypeMapping">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp", line = 81,
   FQN="(anonymous namespace)::TypeMapTy::addTypeMapping", NM="_ZN12_GLOBAL__N_19TypeMapTy14addTypeMappingEPN4llvm4TypeES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.linker/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp -nm=_ZN12_GLOBAL__N_19TypeMapTy14addTypeMappingEPN4llvm4TypeES3_")
  //</editor-fold>
  public void addTypeMapping(Type /*P*/ DstTy, Type /*P*/ SrcTy) {
    assert (SpeculativeTypes.empty());
    assert (SpeculativeDstOpaqueTypes.empty());
    
    // Check to see if these types are recursively isomorphic and establish a
    // mapping between them if so.
    if (!areTypesIsomorphic(DstTy, SrcTy)) {
      // Oops, they aren't isomorphic.  Just discard this request by rolling out
      // any speculative mappings we've established.
      for (Type /*P*/ Ty : SpeculativeTypes)  {
        MappedTypes.erase(Ty);
      }
      
      SrcDefinitionsToResolve.resize(SrcDefinitionsToResolve.size()
             - SpeculativeDstOpaqueTypes.size());
      for (StructType /*P*/ Ty : SpeculativeDstOpaqueTypes)  {
        DstResolvedOpaqueTypes.erase(Ty);
      }
    } else {
      for (Type /*P*/ Ty : SpeculativeTypes)  {
        {
          StructType /*P*/ STy = dyn_cast_StructType(Ty);
          if ((STy != null)) {
            if (STy.hasName()) {
              STy.setName(new StringRef(/*KEEP_STR*/$EMPTY));
            }
          }
        }
      }
    }
    SpeculativeTypes.clear();
    SpeculativeDstOpaqueTypes.clear();
  }

  
  /// Produce a body for an opaque type in the dest module from a type
  /// definition in the source module.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeMapTy::linkDefinedTypeBodies">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp", line = 194,
   FQN="(anonymous namespace)::TypeMapTy::linkDefinedTypeBodies", NM="_ZN12_GLOBAL__N_19TypeMapTy21linkDefinedTypeBodiesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.linker/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp -nm=_ZN12_GLOBAL__N_19TypeMapTy21linkDefinedTypeBodiesEv")
  //</editor-fold>
  public void linkDefinedTypeBodies() {
    SmallVector<Type /*P*/ > Elements/*J*/= new SmallVector<Type /*P*/ >(16, (Type /*P*/ )null);
    for (StructType /*P*/ SrcSTy : SrcDefinitionsToResolve) {
      StructType /*P*/ DstSTy = cast_StructType(MappedTypes.$at_T1$RR(SrcSTy));
      assert (DstSTy.isOpaque());
      
      // Map the body of the source type over to a new body for the dest type.
      Elements.resize(SrcSTy.getNumElements());
      for (/*uint*/int I = 0, E = Elements.size(); I != E; ++I)  {
        Elements.$set(I, get(SrcSTy.getElementType(I)));
      }
      
      DstSTy.setBody(new ArrayRef<Type /*P*/ >(Elements, true), SrcSTy.isPacked());
      DstStructTypesSet.switchToNonOpaque(DstSTy);
    }
    SrcDefinitionsToResolve.clear();
    DstResolvedOpaqueTypes.clear();
  }

  
  /// Return the mapped type to use for the specified input type from the
  /// source module.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeMapTy::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp", line = 226,
   FQN="(anonymous namespace)::TypeMapTy::get", NM="_ZN12_GLOBAL__N_19TypeMapTy3getEPN4llvm4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.linker/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp -nm=_ZN12_GLOBAL__N_19TypeMapTy3getEPN4llvm4TypeE")
  //</editor-fold>
  public Type /*P*/ get(Type /*P*/ Ty) {
    SmallPtrSet<StructType /*P*/ > Visited/*J*/= new SmallPtrSet<StructType /*P*/ >(DenseMapInfo$LikePtr.$Info(), 8);
    return get(Ty, Visited);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeMapTy::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp", line = 231,
   FQN="(anonymous namespace)::TypeMapTy::get", NM="_ZN12_GLOBAL__N_19TypeMapTy3getEPN4llvm4TypeERNS1_11SmallPtrSetIPNS1_10StructTypeELj8EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.linker/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp -nm=_ZN12_GLOBAL__N_19TypeMapTy3getEPN4llvm4TypeERNS1_11SmallPtrSetIPNS1_10StructTypeELj8EEE")
  //</editor-fold>
  public Type /*P*/ get(Type /*P*/ Ty, final SmallPtrSet<StructType /*P*/ > /*&*/ Visited) {
    // If we already have an entry for this type, return it.
    type$ref<Type /*P*/> Entry = /*AddrOf*/MappedTypes.ref$at(Ty);
    if ((/*Deref*/Entry.$deref() != null)) {
      return /*Deref*/Entry.$deref();
    }
    
    // These are types that LLVM itself will unique.
    boolean IsUniqued = !isa_StructType(Ty) || cast_StructType(Ty).isLiteral();
    if (!IsUniqued) {
      for (final std.pair<Type /*P*/ , Type /*P*/ > /*&*/ Pair : MappedTypes) {
        assert (!(Pair.first != Ty && Pair.second == Ty)) : "mapping to a source type";
      }
    }
    if (!IsUniqued && !Visited.insert(cast_StructType(Ty)).second) {
      StructType /*P*/ DTy = StructType.create(Ty.getContext());
      return Entry.$set(DTy);
    }
    
    // If this is not a recursive type, then just map all of the elements and
    // then rebuild the type from inside out.
    SmallVector<Type /*P*/ > ElementTypes/*J*/= new SmallVector<Type /*P*/ >(4, (Type /*P*/ )null);
    
    // If there are no element types to map, then the type is itself.  This is
    // true for the anonymous {} struct, things like 'float', integers, etc.
    if (Ty.getNumContainedTypes() == 0 && IsUniqued) {
      return Entry.$set(Ty);
    }
    
    // Remap all of the elements, keeping track of whether any of them change.
    boolean AnyChange = false;
    ElementTypes.resize(Ty.getNumContainedTypes());
    for (/*uint*/int I = 0, E = Ty.getNumContainedTypes(); I != E; ++I) {
      ElementTypes.$set(I, get(Ty.getContainedType(I), Visited));
      AnyChange |= ElementTypes.$at(I) != Ty.getContainedType(I);
    }
    
    // If we found our type while recursively processing stuff, just use it.
    Entry = /*AddrOf*/MappedTypes.ref$at(Ty);
    if ((/*Deref*/Entry.$deref() != null)) {
      {
        StructType /*P*/ DTy = dyn_cast_StructType(/*Deref*/Entry.$deref());
        if ((DTy != null)) {
          if (DTy.isOpaque()) {
            StructType /*P*/ STy = cast_StructType(Ty);
            finishType(DTy, STy, new ArrayRef<Type /*P*/ >(ElementTypes, true));
          }
        }
      }
      return /*Deref*/Entry.$deref();
    }
    
    // If all of the element types mapped directly over and the type is not
    // a nomed struct, then the type is usable as-is.
    if (!AnyChange && IsUniqued) {
      return Entry.$set(Ty);
    }
    
    // Otherwise, rebuild a modified type.
    switch (Ty.getTypeID()) {
     default:
      throw new llvm_unreachable("unknown derived type to remap");
     case ArrayTyID:
      return Entry.$set(ArrayType.get(ElementTypes.$at(0), 
          cast_ArrayType(Ty).getNumElements()));
     case VectorTyID:
      return Entry.$set(VectorType.get(ElementTypes.$at(0), 
          cast_VectorType(Ty).getNumElements()));
     case PointerTyID:
      return Entry.$set(PointerType.get(ElementTypes.$at(0), 
          cast_PointerType(Ty).getAddressSpace()));
     case FunctionTyID:
      return Entry.$set(FunctionType.get(ElementTypes.$at(0), 
          makeArrayRef(ElementTypes).slice(1), 
          cast_FunctionType(Ty).isVarArg()));
     case StructTyID:
      {
        StructType /*P*/ STy = cast_StructType(Ty);
        boolean IsPacked = STy.isPacked();
        if (IsUniqued) {
          return Entry.$set(StructType.get(Ty.getContext(), new ArrayRef<Type /*P*/ >(ElementTypes, true), IsPacked));
        }
        
        // If the type is opaque, we can just use it directly.
        if (STy.isOpaque()) {
          DstStructTypesSet.addOpaque(STy);
          return Entry.$set(Ty);
        }
        {
          
          StructType /*P*/ OldT = DstStructTypesSet.findNonOpaque(new ArrayRef<Type /*P*/ >(ElementTypes, true), IsPacked);
          if ((OldT != null)) {
            STy.setName(new StringRef(/*KEEP_STR*/$EMPTY));
            return Entry.$set(OldT);
          }
        }
        if (!AnyChange) {
          DstStructTypesSet.addNonOpaque(STy);
          return Entry.$set(Ty);
        }
        
        StructType /*P*/ DTy = StructType.create(Ty.getContext());
        finishType(DTy, STy, new ArrayRef<Type /*P*/ >(ElementTypes, true));
        return Entry.$set(DTy);
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeMapTy::finishType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp", line = 212,
   FQN="(anonymous namespace)::TypeMapTy::finishType", NM="_ZN12_GLOBAL__N_19TypeMapTy10finishTypeEPN4llvm10StructTypeES3_NS1_8ArrayRefIPNS1_4TypeEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.linker/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp -nm=_ZN12_GLOBAL__N_19TypeMapTy10finishTypeEPN4llvm10StructTypeES3_NS1_8ArrayRefIPNS1_4TypeEEE")
  //</editor-fold>
  public void finishType(StructType /*P*/ DTy, StructType /*P*/ STy, 
            ArrayRef<Type /*P*/ > ETypes) {
    DTy.setBody(new ArrayRef<Type /*P*/ >(ETypes), STy.isPacked());
    
    // Steal STy's name.
    if (STy.hasName()) {
      SmallString/*16*/ TmpName = new SmallString/*16*/(STy.getName(), 16);
      STy.setName(new StringRef(/*KEEP_STR*/$EMPTY));
      DTy.setName(TmpName.$StringRef());
    }
    
    DstStructTypesSet.addNonOpaque(DTy);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeMapTy::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp", line = 70,
   FQN="(anonymous namespace)::TypeMapTy::get", NM="_ZN12_GLOBAL__N_19TypeMapTy3getEPN4llvm12FunctionTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.linker/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp -nm=_ZN12_GLOBAL__N_19TypeMapTy3getEPN4llvm12FunctionTypeE")
  //</editor-fold>
  public FunctionType /*P*/ get(FunctionType /*P*/ T) {
    return cast_FunctionType(get((Type /*P*/ )T));
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeMapTy::remapType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp", line = 75,
   FQN="(anonymous namespace)::TypeMapTy::remapType", NM="_ZN12_GLOBAL__N_19TypeMapTy9remapTypeEPN4llvm4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.linker/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp -nm=_ZN12_GLOBAL__N_19TypeMapTy9remapTypeEPN4llvm4TypeE")
  //</editor-fold>
  @Override public/*private*/ Type /*P*/ remapType(Type /*P*/ SrcTy)/* override*/ {
    return get(SrcTy);
  }

  
  
  /// Recursively walk this pair of types, returning true if they are isomorphic,
  /// false if they are not.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeMapTy::areTypesIsomorphic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp", line = 109,
   FQN="(anonymous namespace)::TypeMapTy::areTypesIsomorphic", NM="_ZN12_GLOBAL__N_19TypeMapTy18areTypesIsomorphicEPN4llvm4TypeES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.linker/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp -nm=_ZN12_GLOBAL__N_19TypeMapTy18areTypesIsomorphicEPN4llvm4TypeES3_")
  //</editor-fold>
  private boolean areTypesIsomorphic(Type /*P*/ DstTy, Type /*P*/ SrcTy) {
    // Two types with differing kinds are clearly not isomorphic.
    if (DstTy.getTypeID() != SrcTy.getTypeID()) {
      return false;
    }
    
    // If we have an entry in the MappedTypes table, then we have our answer.
    final type$ref<Type /*P*/> Entry = MappedTypes.ref$at(SrcTy);
    if ((Entry.$deref() != null)) {
      return Entry.$deref() == DstTy;
    }
    
    // Two identical types are clearly isomorphic.  Remember this
    // non-speculatively.
    if (DstTy == SrcTy) {
      Entry.$set(DstTy);
      return true;
    }
    {
      
      // Okay, we have two types with identical kinds that we haven't seen before.
      
      // If this is an opaque struct type, special case it.
      StructType /*P*/ SSTy = dyn_cast_StructType(SrcTy);
      if ((SSTy != null)) {
        // Mapping an opaque type to any struct, just keep the dest struct.
        if (SSTy.isOpaque()) {
          Entry.$set(DstTy);
          SpeculativeTypes.push_back(SrcTy);
          return true;
        }
        
        // Mapping a non-opaque source type to an opaque dest.  If this is the first
        // type that we're mapping onto this destination type then we succeed.  Keep
        // the dest, but fill it in later. If this is the second (different) type
        // that we're trying to map onto the same opaque type then we fail.
        if (cast_StructType(DstTy).isOpaque()) {
          // We can only map one source type onto the opaque destination type.
          if (!DstResolvedOpaqueTypes.insert(cast_StructType(DstTy)).second) {
            return false;
          }
          SrcDefinitionsToResolve.push_back(SSTy);
          SpeculativeTypes.push_back(SrcTy);
          SpeculativeDstOpaqueTypes.push_back(cast_StructType(DstTy));
          Entry.$set(DstTy);
          return true;
        }
      }
    }
    
    // If the number of subtypes disagree between the two types, then we fail.
    if (SrcTy.getNumContainedTypes() != DstTy.getNumContainedTypes()) {
      return false;
    }
    
    // Fail if any of the extra properties (e.g. array size) of the type disagree.
    if (isa_IntegerType(DstTy)) {
      return false; // bitwidth disagrees.
    }
    {
      PointerType /*P*/ PT = dyn_cast_PointerType(DstTy);
      if ((PT != null)) {
        if (PT.getAddressSpace() != cast_PointerType(SrcTy).getAddressSpace()) {
          return false;
        }
      } else {
        FunctionType /*P*/ FT = dyn_cast_FunctionType(DstTy);
        if ((FT != null)) {
          if (FT.isVarArg() != cast_FunctionType(SrcTy).isVarArg()) {
            return false;
          }
        } else {
          StructType /*P*/ DSTy = dyn_cast_StructType(DstTy);
          if ((DSTy != null)) {
            StructType /*P*/ SSTy = cast_StructType(SrcTy);
            if (DSTy.isLiteral() != SSTy.isLiteral()
               || DSTy.isPacked() != SSTy.isPacked()) {
              return false;
            }
          } else {
            ArrayType /*P*/ DATy = dyn_cast_ArrayType(DstTy);
            if ((DATy != null)) {
              if (DATy.getNumElements() != cast_ArrayType(SrcTy).getNumElements()) {
                return false;
              }
            } else {
              VectorType /*P*/ DVTy = dyn_cast_VectorType(DstTy);
              if ((DVTy != null)) {
                if (DVTy.getNumElements() != cast_VectorType(SrcTy).getNumElements()) {
                  return false;
                }
              }
            }
          }
        }
      }
    }
    
    // Otherwise, we speculate that these two types will line up and recursively
    // check the subelements.
    Entry.$set(DstTy);
    SpeculativeTypes.push_back(SrcTy);
    
    for (/*uint*/int I = 0, E = SrcTy.getNumContainedTypes(); I != E; ++I)  {
      if (!areTypesIsomorphic(DstTy.getContainedType(I), 
          SrcTy.getContainedType(I))) {
        return false;
      }
    }
    
    // If everything seems to have lined up, then everything is great.
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TypeMapTy::~TypeMapTy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp", line = 31,
   FQN="(anonymous namespace)::TypeMapTy::~TypeMapTy", NM="_ZN12_GLOBAL__N_19TypeMapTyD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.linker/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp -nm=_ZN12_GLOBAL__N_19TypeMapTyD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    DstResolvedOpaqueTypes.$destroy();
    SrcDefinitionsToResolve.$destroy();
    SpeculativeDstOpaqueTypes.$destroy();
    SpeculativeTypes.$destroy();
    MappedTypes.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "MappedTypes=" + MappedTypes // NOI18N
              + ", SpeculativeTypes=" + SpeculativeTypes // NOI18N
              + ", SpeculativeDstOpaqueTypes=" + SpeculativeDstOpaqueTypes // NOI18N
              + ", SrcDefinitionsToResolve=" + SrcDefinitionsToResolve // NOI18N
              + ", DstResolvedOpaqueTypes=" + DstResolvedOpaqueTypes // NOI18N
              + ", DstStructTypesSet=" + DstStructTypesSet // NOI18N
              + super.toString(); // NOI18N
  }
}
