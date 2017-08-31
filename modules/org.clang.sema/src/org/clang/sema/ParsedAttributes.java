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

package org.clang.sema;

import org.clank.support.*;
import org.clank.support.aliases.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.basic.*;


/// ParsedAttributes - A collection of parsed attributes.  Currently
/// we don't differentiate between the various attribute syntaxes,
/// which is basically silly.
///
/// Right now this is a very lightweight container, but the expectation
/// is that this will become significantly more serious.
//<editor-fold defaultstate="collapsed" desc="clang::ParsedAttributes">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 718,
 FQN="clang::ParsedAttributes", NM="_ZN5clang16ParsedAttributesE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN5clang16ParsedAttributesE")
//</editor-fold>
public class ParsedAttributes implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ParsedAttributes::ParsedAttributes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 720,
   FQN="clang::ParsedAttributes::ParsedAttributes", NM="_ZN5clang16ParsedAttributesC1ERNS_16AttributeFactoryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN5clang16ParsedAttributesC1ERNS_16AttributeFactoryE")
  //</editor-fold>
  public ParsedAttributes(final AttributeFactory /*&*/ factory) {
    // : pool(factory), list(null) 
    //START JInit
    this.pool = new AttributePool(factory);
    this.list = null;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ParsedAttributes::ParsedAttributes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 724,
   FQN="clang::ParsedAttributes::ParsedAttributes", NM="_ZN5clang16ParsedAttributesC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN5clang16ParsedAttributesC1ERKS0_")
  //</editor-fold>
  public ParsedAttributes(final /*const*/ ParsedAttributes /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  
  //<editor-fold defaultstate="collapsed" desc="clang::ParsedAttributes::getPool">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 726,
   FQN="clang::ParsedAttributes::getPool", NM="_ZNK5clang16ParsedAttributes7getPoolEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZNK5clang16ParsedAttributes7getPoolEv")
  //</editor-fold>
  public AttributePool /*&*/ getPool() /*const*/ {
    return pool;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ParsedAttributes::empty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 728,
   FQN="clang::ParsedAttributes::empty", NM="_ZNK5clang16ParsedAttributes5emptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZNK5clang16ParsedAttributes5emptyEv")
  //</editor-fold>
  public boolean empty() /*const*/ {
    return list == null;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ParsedAttributes::add">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 730,
   FQN="clang::ParsedAttributes::add", NM="_ZN5clang16ParsedAttributes3addEPNS_13AttributeListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN5clang16ParsedAttributes3addEPNS_13AttributeListE")
  //</editor-fold>
  public void add(AttributeList /*P*/ newAttr) {
    assert Native.$bool(newAttr);
    assert (newAttr.getNext() == null);
    newAttr.setNext(list);
    list = newAttr;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ParsedAttributes::addAll">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 737,
   FQN="clang::ParsedAttributes::addAll", NM="_ZN5clang16ParsedAttributes6addAllEPNS_13AttributeListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN5clang16ParsedAttributes6addAllEPNS_13AttributeListE")
  //</editor-fold>
  public void addAll(AttributeList /*P*/ newList) {
    if (!(newList != null)) {
      return;
    }
    
    AttributeList /*P*/ lastInNewList = newList;
    {
      AttributeList /*P*/ next;
      while (((/*P*/ next = lastInNewList.getNext()) != null)) {
        lastInNewList = next;
      }
    }
    
    lastInNewList.setNext(list);
    list = newList;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ParsedAttributes::set">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 748,
   FQN="clang::ParsedAttributes::set", NM="_ZN5clang16ParsedAttributes3setEPNS_13AttributeListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN5clang16ParsedAttributes3setEPNS_13AttributeListE")
  //</editor-fold>
  public void set(AttributeList /*P*/ newList) {
    list = newList;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ParsedAttributes::takeAllFrom">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 752,
   FQN="clang::ParsedAttributes::takeAllFrom", NM="_ZN5clang16ParsedAttributes11takeAllFromERS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN5clang16ParsedAttributes11takeAllFromERS0_")
  //</editor-fold>
  public void takeAllFrom(final ParsedAttributes /*&*/ attrs) {
    addAll(attrs.list);
    attrs.list = null;
    pool.takeAllFrom(attrs.pool);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ParsedAttributes::clear">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 758,
   FQN="clang::ParsedAttributes::clear", NM="_ZN5clang16ParsedAttributes5clearEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN5clang16ParsedAttributes5clearEv")
  //</editor-fold>
  public void clear() {
    list = null;
    pool.clear();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ParsedAttributes::getList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 759,
   FQN="clang::ParsedAttributes::getList", NM="_ZNK5clang16ParsedAttributes7getListEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZNK5clang16ParsedAttributes7getListEv")
  //</editor-fold>
  public AttributeList /*P*/ getList() /*const*/ {
    return list;
  }

  
  /// Returns a reference to the attribute list.  Try not to introduce
  /// dependencies on this method, it may not be long-lived.
  //<editor-fold defaultstate="collapsed" desc="clang::ParsedAttributes::getListRef">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 763,
   FQN="clang::ParsedAttributes::getListRef", NM="_ZN5clang16ParsedAttributes10getListRefEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN5clang16ParsedAttributes10getListRefEv")
  //</editor-fold>
  public type$ref<AttributeList/*P*/>/*&*/ getListRef() {
    return list$Ref;
  }

  
  /// Add attribute with expression arguments.
  //<editor-fold defaultstate="collapsed" desc="clang::ParsedAttributes::addNew">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 766,
   FQN="clang::ParsedAttributes::addNew", NM="_ZN5clang16ParsedAttributes6addNewEPNS_14IdentifierInfoENS_11SourceRangeES2_NS_14SourceLocationEPN4llvm12PointerUnionIPNS_4ExprEPNS_13IdentifierLocEEEjNS_13AttributeList6SyntaxES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN5clang16ParsedAttributes6addNewEPNS_14IdentifierInfoENS_11SourceRangeES2_NS_14SourceLocationEPN4llvm12PointerUnionIPNS_4ExprEPNS_13IdentifierLocEEEjNS_13AttributeList6SyntaxES4_")
  //</editor-fold>
  public AttributeList /*P*/ addNew(IdentifierInfo /*P*/ attrName, SourceRange attrRange, 
        IdentifierInfo /*P*/ scopeName, SourceLocation scopeLoc, 
        type$ptr<PointerUnion<Expr /*P*/ , IdentifierLoc /*P*/ >>/*P*/ args, /*uint*/int numArgs, 
        AttributeList.Syntax syntax) {
    return addNew(attrName, attrRange, 
        scopeName, scopeLoc, 
        args, numArgs, 
        syntax, 
        new SourceLocation());
  }
  public AttributeList /*P*/ addNew(IdentifierInfo /*P*/ attrName, SourceRange attrRange, 
        IdentifierInfo /*P*/ scopeName, SourceLocation scopeLoc, 
        type$ptr<PointerUnion<Expr /*P*/ , IdentifierLoc /*P*/ >>/*P*/ args, /*uint*/int numArgs, 
        AttributeList.Syntax syntax, 
        SourceLocation ellipsisLoc/*= SourceLocation()*/) {
    AttributeList /*P*/ attr = pool.create(attrName, new SourceRange(attrRange), scopeName, new SourceLocation(scopeLoc), args, numArgs, 
        syntax, new SourceLocation(ellipsisLoc));
    add(attr);
    return attr;
  }

  
  /// Add availability attribute.
  //<editor-fold defaultstate="collapsed" desc="clang::ParsedAttributes::addNew">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 779,
   FQN="clang::ParsedAttributes::addNew", NM="_ZN5clang16ParsedAttributes6addNewEPNS_14IdentifierInfoENS_11SourceRangeES2_NS_14SourceLocationEPNS_13IdentifierLocERKNS_18AvailabilityChangeES9_S9_S4_PKNS_4ExprENS_13AttributeList6SyntaxES4_SC_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN5clang16ParsedAttributes6addNewEPNS_14IdentifierInfoENS_11SourceRangeES2_NS_14SourceLocationEPNS_13IdentifierLocERKNS_18AvailabilityChangeES9_S9_S4_PKNS_4ExprENS_13AttributeList6SyntaxES4_SC_")
  //</editor-fold>
  public AttributeList /*P*/ addNew(IdentifierInfo /*P*/ attrName, SourceRange attrRange, 
        IdentifierInfo /*P*/ scopeName, SourceLocation scopeLoc, 
        IdentifierLoc /*P*/ Param, 
        final /*const*/ AvailabilityChange /*&*/ introduced, 
        final /*const*/ AvailabilityChange /*&*/ deprecated, 
        final /*const*/ AvailabilityChange /*&*/ obsoleted, 
        SourceLocation unavailable, 
        /*const*/ Expr /*P*/ MessageExpr, 
        AttributeList.Syntax syntax, 
        SourceLocation strict, /*const*/ Expr /*P*/ ReplacementExpr) {
    AttributeList /*P*/ attr = pool.create(attrName, new SourceRange(attrRange), scopeName, new SourceLocation(scopeLoc), Param, introduced, 
        deprecated, obsoleted, new SourceLocation(unavailable), MessageExpr, syntax, 
        new SourceLocation(strict), ReplacementExpr);
    add(attr);
    return attr;
  }

  
  /// Add objc_bridge_related attribute.
  //<editor-fold defaultstate="collapsed" desc="clang::ParsedAttributes::addNew">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 798,
   FQN="clang::ParsedAttributes::addNew", NM="_ZN5clang16ParsedAttributes6addNewEPNS_14IdentifierInfoENS_11SourceRangeES2_NS_14SourceLocationEPNS_13IdentifierLocES6_S6_NS_13AttributeList6SyntaxE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN5clang16ParsedAttributes6addNewEPNS_14IdentifierInfoENS_11SourceRangeES2_NS_14SourceLocationEPNS_13IdentifierLocES6_S6_NS_13AttributeList6SyntaxE")
  //</editor-fold>
  public AttributeList /*P*/ addNew(IdentifierInfo /*P*/ attrName, SourceRange attrRange, 
        IdentifierInfo /*P*/ scopeName, SourceLocation scopeLoc, 
        IdentifierLoc /*P*/ Param1, 
        IdentifierLoc /*P*/ Param2, 
        IdentifierLoc /*P*/ Param3, 
        AttributeList.Syntax syntax) {
    AttributeList /*P*/ attr = pool.create(attrName, new SourceRange(attrRange), scopeName, new SourceLocation(scopeLoc), 
        Param1, Param2, Param3, syntax);
    add(attr);
    return attr;
  }

  
  /// Add type_tag_for_datatype attribute.
  //<editor-fold defaultstate="collapsed" desc="clang::ParsedAttributes::addNewTypeTagForDatatype">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 812,
   FQN="clang::ParsedAttributes::addNewTypeTagForDatatype", NM="_ZN5clang16ParsedAttributes24addNewTypeTagForDatatypeEPNS_14IdentifierInfoENS_11SourceRangeES2_NS_14SourceLocationEPNS_13IdentifierLocENS_9OpaquePtrINS_8QualTypeEEEbbNS_13AttributeList6SyntaxE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN5clang16ParsedAttributes24addNewTypeTagForDatatypeEPNS_14IdentifierInfoENS_11SourceRangeES2_NS_14SourceLocationEPNS_13IdentifierLocENS_9OpaquePtrINS_8QualTypeEEEbbNS_13AttributeList6SyntaxE")
  //</editor-fold>
  public AttributeList /*P*/ addNewTypeTagForDatatype(IdentifierInfo /*P*/ attrName, SourceRange attrRange, 
                          IdentifierInfo /*P*/ scopeName, SourceLocation scopeLoc, 
                          IdentifierLoc /*P*/ argumentKind, OpaquePtr<QualType> matchingCType, 
                          boolean layoutCompatible, boolean mustBeNull, 
                          AttributeList.Syntax syntax) {
    AttributeList /*P*/ attr = pool.createTypeTagForDatatype(attrName, new SourceRange(attrRange), 
        scopeName, new SourceLocation(scopeLoc), 
        argumentKind, new OpaquePtr<QualType>(matchingCType), 
        layoutCompatible, mustBeNull, syntax);
    add(attr);
    return attr;
  }

  
  /// Add an attribute with a single type argument.
  //<editor-fold defaultstate="collapsed" desc="clang::ParsedAttributes::addNewTypeAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 828,
   FQN="clang::ParsedAttributes::addNewTypeAttr", NM="_ZN5clang16ParsedAttributes14addNewTypeAttrEPNS_14IdentifierInfoENS_11SourceRangeES2_NS_14SourceLocationENS_9OpaquePtrINS_8QualTypeEEENS_13AttributeList6SyntaxE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN5clang16ParsedAttributes14addNewTypeAttrEPNS_14IdentifierInfoENS_11SourceRangeES2_NS_14SourceLocationENS_9OpaquePtrINS_8QualTypeEEENS_13AttributeList6SyntaxE")
  //</editor-fold>
  public AttributeList /*P*/ addNewTypeAttr(IdentifierInfo /*P*/ attrName, SourceRange attrRange, 
                IdentifierInfo /*P*/ scopeName, SourceLocation scopeLoc, 
                OpaquePtr<QualType> typeArg, AttributeList.Syntax syntaxUsed) {
    AttributeList /*P*/ attr = pool.createTypeAttribute(attrName, new SourceRange(attrRange), scopeName, new SourceLocation(scopeLoc), 
        new OpaquePtr<QualType>(typeArg), syntaxUsed);
    add(attr);
    return attr;
  }

  
  /// Add microsoft __delspec(property) attribute.
  //<editor-fold defaultstate="collapsed" desc="clang::ParsedAttributes::addNewPropertyAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 840,
   FQN="clang::ParsedAttributes::addNewPropertyAttr", NM="_ZN5clang16ParsedAttributes18addNewPropertyAttrEPNS_14IdentifierInfoENS_11SourceRangeES2_NS_14SourceLocationES2_S2_NS_13AttributeList6SyntaxE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN5clang16ParsedAttributes18addNewPropertyAttrEPNS_14IdentifierInfoENS_11SourceRangeES2_NS_14SourceLocationES2_S2_NS_13AttributeList6SyntaxE")
  //</editor-fold>
  public AttributeList /*P*/ addNewPropertyAttr(IdentifierInfo /*P*/ attrName, SourceRange attrRange, 
                    IdentifierInfo /*P*/ scopeName, SourceLocation scopeLoc, 
                    IdentifierInfo /*P*/ getterId, IdentifierInfo /*P*/ setterId, 
                    AttributeList.Syntax syntaxUsed) {
    AttributeList /*P*/ attr = pool.createPropertyAttribute(attrName, new SourceRange(attrRange), scopeName, new SourceLocation(scopeLoc), 
        getterId, setterId, syntaxUsed);
    add(attr);
    return attr;
  }

/*private:*/
  private /*mutable */AttributePool pool;
  private AttributeList /*P*/ list;
  private final type$ref<AttributeList> /*P &*/ list$Ref = new type$ref<AttributeList>() {
    @Override public AttributeList $deref() { return list; }
    @Override public AttributeList $set(AttributeList value) { return list = value; }
  };
  //<editor-fold defaultstate="collapsed" desc="clang::ParsedAttributes::~ParsedAttributes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 718,
   FQN="clang::ParsedAttributes::~ParsedAttributes", NM="_ZN5clang16ParsedAttributesD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN5clang16ParsedAttributesD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    pool.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "pool=" + pool // NOI18N
              + ", list=" + list; // NOI18N
  }
}
