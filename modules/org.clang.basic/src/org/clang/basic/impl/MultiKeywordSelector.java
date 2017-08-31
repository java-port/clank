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

package org.clang.basic.impl;

import org.clang.basic.DeclarationNameExtra;
import org.clang.basic.IdentifierInfo;
import org.clank.java.*;
import org.clank.support.*;
import static org.clank.support.Native.$tryClone;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.llvm.adt.*;

/// MultiKeywordSelector - One of these variable length records is kept for each
/// selector containing more than one keyword. We use a folding set
/// to unique aggregate names (keyword selectors in ObjC parlance). Access to
/// this class is provided strictly through Selector.
//<editor-fold defaultstate="collapsed" desc="clang::MultiKeywordSelector">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp", line = 354,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp", old_line = 353,
 FQN="clang::MultiKeywordSelector", NM="_ZN5clang20MultiKeywordSelectorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZN5clang20MultiKeywordSelectorE")
//</editor-fold>
public class MultiKeywordSelector extends /*public*/ DeclarationNameExtra implements /*public*/ FoldingSetNode, NativeType.SizeofCapable {
  
  //<editor-fold defaultstate="collapsed" desc="clang::MultiKeywordSelector::MultiKeywordSelector">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp", line = 356,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp", old_line = 355,
   FQN="clang::MultiKeywordSelector::MultiKeywordSelector", NM="_ZN5clang20MultiKeywordSelectorC1Ej",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZN5clang20MultiKeywordSelectorC1Ej")
  //</editor-fold>
  private MultiKeywordSelector(/*uint*/int nKeys) {
    /* : DeclarationNameExtra(), FoldingSetNode()*/ 
    //START JInit
    super();
    //END JInit
    $this$plus1 = null;
    ExtraKindOrNumArgs = ExtraKind.NUM_EXTRA_KINDS.getValue() + nKeys;
  }

/*public:*/
  // Constructor for keyword selectors.
  //<editor-fold defaultstate="collapsed" desc="clang::MultiKeywordSelector::MultiKeywordSelector">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*Alloc*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp", line = 361,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp", old_line = 360,
   FQN="clang::MultiKeywordSelector::MultiKeywordSelector", NM="_ZN5clang20MultiKeywordSelectorC1EjPPNS_14IdentifierInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZN5clang20MultiKeywordSelectorC1EjPPNS_14IdentifierInfoE")
  //</editor-fold>
  public MultiKeywordSelector(type$ptr<?> this$plus1, /*uint*/int nKeys, type$ptr<IdentifierInfo> IIV) {
    /* : DeclarationNameExtra(), FoldingSetNode()*/ 
    //START JInit
    super();
    //END JInit
    $this$plus1 = (type$ptr<IdentifierInfo>)Native.$toConst(this$plus1);
    assert ((nKeys > 1)) : "not a multi-keyword selector";
    ExtraKindOrNumArgs = ExtraKind.NUM_EXTRA_KINDS.getValue() + nKeys;
    
    // Fill in the trailing keyword array.
    type$ptr<IdentifierInfo> KeyInfo = (type$ptr<IdentifierInfo>) this.getPtrAfterThis();
    for (/*uint*/int i = 0; i != nKeys; ++i)  {
      KeyInfo.$set(i, IIV.$at(i));
    }
  }
  
  // getName - Derive the full selector name and return it.
  //<editor-fold defaultstate="collapsed" desc="clang::MultiKeywordSelector::getName">
  @Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp", line = 425,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp", old_line = 424,
   FQN="clang::MultiKeywordSelector::getName", NM="_ZNK5clang20MultiKeywordSelector7getNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZNK5clang20MultiKeywordSelector7getNameEv")
  //</editor-fold>
  public std.string getName() /*const*/ {
    raw_svector_ostream OS = null;
    try {
      SmallString/*256*/ Str/*J*/= new SmallString(256);
      OS/*J*/= new raw_svector_ostream(Str);
      for (type$ptr<IdentifierInfo> I = $tryClone(keyword_begin()), E = keyword_end(); I.$noteq(E); I.$preInc()) {
        if ((/*Deref*/I.$star() != null)) {
          OS.$out((/*Deref*/I.$star()).getName());
        }
        OS.$out_char($$COLON);
      }
      
      return OS.str().$string();
    } finally {
      if (OS != null) { OS.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MultiKeywordSelector::getNumArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp", line = 374,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp", old_line = 373,
   FQN="clang::MultiKeywordSelector::getNumArgs", NM="_ZNK5clang20MultiKeywordSelector10getNumArgsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZNK5clang20MultiKeywordSelector10getNumArgsEv")
  //</editor-fold>
  public /*uint*/int getNumArgs() /*const*/ {
    return ExtraKindOrNumArgs - ExtraKind.NUM_EXTRA_KINDS.getValue();
  }

  @Override
  public type$ptr<IdentifierInfo> getPtrAfterThis() {
    // TODO: either keep array of IdentifierInfo inside or ask global mgr
    return $this$plus1;
  }
  private final type$ptr<IdentifierInfo> $this$plus1;
  
  /*typedef IdentifierInfo *const *keyword_iterator*/
//  public final class keyword_iterator extends IdentifierInfo /*P*/ /*const*/ /*P*/ { };
  //<editor-fold defaultstate="collapsed" desc="clang::MultiKeywordSelector::keyword_begin">
  @Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp", line = 377,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp", old_line = 376,
   FQN="clang::MultiKeywordSelector::keyword_begin", NM="_ZNK5clang20MultiKeywordSelector13keyword_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZNK5clang20MultiKeywordSelector13keyword_beginEv")
  //</editor-fold>
  public type$ptr<IdentifierInfo> keyword_begin() /*const*/ {
    return this.getPtrAfterThis();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MultiKeywordSelector::keyword_end">
  @Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp", line = 380,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp", old_line = 379,
   FQN="clang::MultiKeywordSelector::keyword_end", NM="_ZNK5clang20MultiKeywordSelector11keyword_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZNK5clang20MultiKeywordSelector11keyword_endEv")
  //</editor-fold>
  public type$ptr<IdentifierInfo> keyword_end() /*const*/ {
    return keyword_begin().$add(getNumArgs());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MultiKeywordSelector::getIdentifierInfoForSlot">
  @Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp", line = 383,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp", old_line = 382,
   FQN="clang::MultiKeywordSelector::getIdentifierInfoForSlot", NM="_ZNK5clang20MultiKeywordSelector24getIdentifierInfoForSlotEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZNK5clang20MultiKeywordSelector24getIdentifierInfoForSlotEj")
  //</editor-fold>
  public IdentifierInfo /*P*/ getIdentifierInfoForSlot(/*uint*/int i) /*const*/ {
    assert (i < getNumArgs()) : "getIdentifierInfoForSlot(): illegal index";
    return keyword_begin().$at(i);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MultiKeywordSelector::Profile">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp", line = 387,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp", old_line = 386,
   FQN="clang::MultiKeywordSelector::Profile", NM="_ZN5clang20MultiKeywordSelector7ProfileERN4llvm16FoldingSetNodeIDEPKPNS_14IdentifierInfoEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZN5clang20MultiKeywordSelector7ProfileERN4llvm16FoldingSetNodeIDEPKPNS_14IdentifierInfoEj")
  //</editor-fold>
  public static void Profile(FoldingSetNodeID /*&*/ ID, type$ptr<IdentifierInfo> ArgTys, /*uint*/int NumArgs) {
    ID.AddInteger_uint(NumArgs);
    for (/*uint*/int i = 0; i != NumArgs; ++i)  {
      ID.AddPointer(ArgTys.$at(i));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MultiKeywordSelector::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp", line = 393,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp", old_line = 392,
   FQN="clang::MultiKeywordSelector::Profile", NM="_ZN5clang20MultiKeywordSelector7ProfileERN4llvm16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZN5clang20MultiKeywordSelector7ProfileERN4llvm16FoldingSetNodeIDE")
  //</editor-fold>
  public void Profile(FoldingSetNodeID /*&*/ ID) {
    Profile(ID, keyword_begin(), getNumArgs());
  }

  @Override
  public int $sizeof() {
    return $sizeof_MultiKeywordSelector();
  }
  
  public static int $sizeof_MultiKeywordSelector() {
    return NativeType.BYTES_IN_JAVA_OBJECT_HEADER /* + super?*/;
  }  
}
