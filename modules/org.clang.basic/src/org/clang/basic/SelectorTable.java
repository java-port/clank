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

package org.clang.basic;

import static org.clank.support.Native.$AddrOf;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import org.clang.basic.impl.*;
import static org.clang.basic.BasicClangGlobals.*;
import static org.clang.basic.impl.IdentifierTableStatics.*;
import static org.clank.support.NativePointer.create_type$ref;

/// \brief This table allows us to fully hide how we implement
/// multi-keyword caching.
//<editor-fold defaultstate="collapsed" desc="clang::SelectorTable">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", line = 755,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", old_line = 740,
 FQN="clang::SelectorTable", NM="_ZN5clang13SelectorTableE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZN5clang13SelectorTableE")
//</editor-fold>
public class SelectorTable implements Destructors.ClassWithDestructor {
  private Object/*void P*/ Impl; // Actually a SelectorTableImpl
  //<editor-fold defaultstate="collapsed" desc="clang::SelectorTable::SelectorTable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", line = 757,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", old_line = 742,
   FQN="clang::SelectorTable::SelectorTable", NM="_ZN5clang13SelectorTableC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZN5clang13SelectorTableC1ERKS0_")
  //</editor-fold>
  private SelectorTable(/*const*/ SelectorTable /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="clang::SelectorTable::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", line = 758,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", old_line = 743,
   FQN="clang::SelectorTable::operator=", NM="_ZN5clang13SelectorTableaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZN5clang13SelectorTableaSERKS0_")
  //</editor-fold>
  private void $assign(/*const*/ SelectorTable /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::SelectorTable::SelectorTable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp", line = 629,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp", old_line = 628,
   FQN="clang::SelectorTable::SelectorTable", NM="_ZN5clang13SelectorTableC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZN5clang13SelectorTableC1Ev")
  //</editor-fold>
  public SelectorTable() {
    Impl = new SelectorTableImpl();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::SelectorTable::~SelectorTable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp", line = 633,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp", old_line = 632,
   FQN="clang::SelectorTable::~SelectorTable", NM="_ZN5clang13SelectorTableD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZN5clang13SelectorTableD0Ev")
  //</editor-fold>
  public void $destroy() {
    if (/*AddrOf*/getSelectorTableImpl(Impl) != null) { /*AddrOf*/getSelectorTableImpl(Impl).$destroy();};
  }

  
  /// \brief Can create any sort of selector.
  ///
  /// \p NumArgs indicates whether this is a no argument selector "foo", a
  /// single argument selector "foo:" or multi-argument "foo:bar:".
  //<editor-fold defaultstate="collapsed" desc="clang::SelectorTable::getSelector">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*Alloc*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp", line = 603,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp", old_line = 602,
   FQN="clang::SelectorTable::getSelector", NM="_ZN5clang13SelectorTable11getSelectorEjPPNS_14IdentifierInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZN5clang13SelectorTable11getSelectorEjPPNS_14IdentifierInfoE")
  //</editor-fold>
  public Selector getSelector(/*uint*/int nKeys, type$ptr<IdentifierInfo> /*P*/ /*P*/ IIV) {
    if ($less_uint(nKeys, 2)) {
      return new Selector(IIV.$at(0), nKeys);
    }

    SelectorTableImpl /*&*/ SelTabImpl = getSelectorTableImpl(Impl);

    // Unique selector, to guarantee there is one per name.
    FoldingSetNodeID ID/*J*/= new FoldingSetNodeID();
    MultiKeywordSelector.Profile(ID, IIV, nKeys);

    final type$ref<type$ptr<MultiKeywordSelector/*P*/>/*void P*/> InsertPos = create_type$ref();
    {
      MultiKeywordSelector /*P*/ SI = SelTabImpl.Table.FindNodeOrInsertPos(ID, InsertPos);
      if ((SI != null)) {
        return new Selector(SI, JD$FAKE.TRAILING, JD$FAKE.TRAILING);
      }
    }

    // MultiKeywordSelector objects are not allocated with new because they have a
    // variable size array (for parameter types) at the end of them.
//    /*uint*/int Size = MultiKeywordSelector.$sizeof_MultiKeywordSelector() + nKeys * sizeof(IdentifierInfo.class /*P*/ );
//      MultiKeywordSelector /*P*/ SI = (MultiKeywordSelector /*P*/ )SelTabImpl.Allocator.Allocate(Size, 
//          llvm.alignOf<MultiKeywordSelector>());
//      /*FIXME:*/SI = /*new (SI)*/ new MultiKeywordSelector(nKeys, IIV);
//      SelTabImpl.Table.InsertNode(SI, InsertPos);
//      return new Selector(SI);
//    MultiKeywordSelector /*P*/ SI = (MultiKeywordSelector /*P*/ )SelTabImpl.Allocator.Allocate(Size, llvm.alignOf(MultiKeywordSelector.class));
    MultiKeywordSelector /*P*/ SI;
    if (false) {
      /*uint*/int Size = MultiKeywordSelector.$sizeof_MultiKeywordSelector() + nKeys * $sizeof_ptr(/*IdentifierInfo  */);
      SI = (MultiKeywordSelector /*P*/ )SelTabImpl.Allocator.Allocate(Size,
              alignOf(MultiKeywordSelector.class));
      /*NEW_EXPR [System]*/SI = /*new (SI)*/ $new_uint_voidPtr(SI, (type$ptr<?> New$Mem)->{
          return new MultiKeywordSelector(null, nKeys, IIV);
       });    
    } else {
      /*uint*/int Size = 1/*$sizeof_MultiKeywordSelector()*/ + nKeys * 1;//$sizeof_ptr(/*IdentifierInfo  */);
      type$ptr<?> $Mem = SelTabImpl.Allocator.Allocate$JavaRef(Size);
      /*NEW_EXPR [System]*/SI = /*new (SI)*/ $new_uint_voidPtr($Mem, (type$ptr<?> New$Mem)->{
          return new MultiKeywordSelector(New$Mem.$add(1), nKeys, IIV);
       });    
      ((type$ptr)$Mem).$set(SI);
    }
    SelTabImpl.Table.InsertNode(SI, InsertPos.$deref());
    return new Selector(SI, JD$FAKE.TRAILING, JD$FAKE.TRAILING);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::SelectorTable::getUnarySelector">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", line = 769,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", old_line = 754,
   FQN="clang::SelectorTable::getUnarySelector", NM="_ZN5clang13SelectorTable16getUnarySelectorEPNS_14IdentifierInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZN5clang13SelectorTable16getUnarySelectorEPNS_14IdentifierInfoE")
  //</editor-fold>
  public Selector getUnarySelector(IdentifierInfo /*P*/ ID) {
    return new Selector(ID, 1);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::SelectorTable::getNullarySelector">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", line = 772,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", old_line = 757,
   FQN="clang::SelectorTable::getNullarySelector", NM="_ZN5clang13SelectorTable18getNullarySelectorEPNS_14IdentifierInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZN5clang13SelectorTable18getNullarySelectorEPNS_14IdentifierInfoE")
  //</editor-fold>
  public Selector getNullarySelector(IdentifierInfo /*P*/ ID) {
    return new Selector(ID, 0);
  }

  
  /// \brief Return the total amount of memory allocated for managing selectors.
  //<editor-fold defaultstate="collapsed" desc="clang::SelectorTable::getTotalMemory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp", line = 598,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp", old_line = 597,
   FQN="clang::SelectorTable::getTotalMemory", NM="_ZNK5clang13SelectorTable14getTotalMemoryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZNK5clang13SelectorTable14getTotalMemoryEv")
  //</editor-fold>
  public /*size_t*/int getTotalMemory() /*const*/ {
    SelectorTableImpl /*&*/ SelTabImpl = getSelectorTableImpl(Impl);
    return Unsigned.$long2uint(SelTabImpl.Allocator.getTotalMemory());
  }

  
  /// \brief Return the default setter name for the given identifier.
  ///
  /// This is "set" + \p Name where the initial character of \p Name
  /// has been capitalized.
  //<editor-fold defaultstate="collapsed" desc="clang::SelectorTable::constructSetterName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp", line = 581,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp", old_line = 580,
   FQN="clang::SelectorTable::constructSetterName", NM="_ZN5clang13SelectorTable19constructSetterNameEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZN5clang13SelectorTable19constructSetterNameEN4llvm9StringRefE")
  //</editor-fold>
  public static SmallString/*64*/ constructSetterName(StringRef Name) {
    SmallString/*64*/ SetterName/*J*/= new SmallString/*64*/(64, new StringRef(/*KEEP_STR*/"set"));
    SetterName.$addassign(/*NO_COPY*/Name);
    SetterName.$set(3, toUppercase(SetterName.$at(3)));
    return SetterName;
  }

  
  /// \brief Return the default setter selector for the given identifier.
  ///
  /// This is "set" + \p Name where the initial character of \p Name
  /// has been capitalized.
  //<editor-fold defaultstate="collapsed" desc="clang::SelectorTable::constructSetterSelector">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   optimized = Converted.Optimization.VALUE_TYPE,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp", line = 589,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp", old_line = 588,
   FQN="clang::SelectorTable::constructSetterSelector", NM="_ZN5clang13SelectorTable23constructSetterSelectorERNS_15IdentifierTableERS0_PKNS_14IdentifierInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZN5clang13SelectorTable23constructSetterSelectorERNS_15IdentifierTableERS0_PKNS_14IdentifierInfoE")
  //</editor-fold>
  public static Selector constructSetterSelector(IdentifierTable /*&*/ Idents, 
                         SelectorTable /*&*/ SelTable, 
                         /*const*/ IdentifierInfo /*P*/ Name) {
    IdentifierInfo /*P*/ SetterName = $AddrOf(Idents.get(constructSetterName(Name.getName())/*PERF: .$StringRef()*/));
    return SelTable.getUnarySelector(SetterName);
  }

  
  public String toString() {
    return "" + "Impl=" + Impl; // NOI18N
  }
}
