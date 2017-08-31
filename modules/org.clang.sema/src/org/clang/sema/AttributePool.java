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
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.basic.*;
import static org.clang.sema.java.SemaSizeofAndAlignment.*;

//<editor-fold defaultstate="collapsed" desc="clang::AttributePool">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 581,
 FQN="clang::AttributePool", NM="_ZN5clang13AttributePoolE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN5clang13AttributePoolE")
//</editor-fold>
public class AttributePool implements Destructors.ClassWithDestructor {
  private final AttributeFactory /*&*/ Factory;
  private AttributeList /*P*/ Head;
  
  //<editor-fold defaultstate="collapsed" desc="clang::AttributePool::allocate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 585,
   FQN="clang::AttributePool::allocate", NM="_ZN5clang13AttributePool8allocateEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN5clang13AttributePool8allocateEj")
  //</editor-fold>
  private Object/*void P*/ allocate(/*size_t*/int size) {
    return Factory.allocate(size);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AttributePool::add">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 589,
   FQN="clang::AttributePool::add", NM="_ZN5clang13AttributePool3addEPNS_13AttributeListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN5clang13AttributePool3addEPNS_13AttributeListE")
  //</editor-fold>
  private AttributeList /*P*/ add(AttributeList /*P*/ attr) {
    // We don't care about the order of the pool.
    attr.NextInPool = Head;
    Head = attr;
    return attr;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AttributePool::takePool">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp", line = 91,
   FQN="clang::AttributePool::takePool", NM="_ZN5clang13AttributePool8takePoolEPNS_13AttributeListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN5clang13AttributePool8takePoolEPNS_13AttributeListE")
  //</editor-fold>
  private void takePool(AttributeList /*P*/ pool) {
    assert (pool != null);
    
    // Fast path:  this pool is empty.
    if (!(Head != null)) {
      Head = pool;
      return;
    }
    
    // Reverse the pool onto the current head.  This optimizes for the
    // pattern of pulling a lot of pools into a single pool.
    do {
      AttributeList /*P*/ next = pool.NextInPool;
      pool.NextInPool = Head;
      Head = pool;
      pool = next;
    } while ((pool != null));
  }

/*public:*/
  /// Create a new pool for a factory.
  //<editor-fold defaultstate="collapsed" desc="clang::AttributePool::AttributePool">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 600,
   FQN="clang::AttributePool::AttributePool", NM="_ZN5clang13AttributePoolC1ERNS_16AttributeFactoryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN5clang13AttributePoolC1ERNS_16AttributeFactoryE")
  //</editor-fold>
  public AttributePool(final AttributeFactory /*&*/ factory) {
    // : Factory(factory), Head(null) 
    //START JInit
    this./*&*/Factory=/*&*/factory;
    this.Head = null;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AttributePool::AttributePool">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 602,
   FQN="clang::AttributePool::AttributePool", NM="_ZN5clang13AttributePoolC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN5clang13AttributePoolC1ERKS0_")
  //</editor-fold>
  public AttributePool(final /*const*/ AttributePool /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  
  /// Move the given pool's allocations to this pool.
  //<editor-fold defaultstate="collapsed" desc="clang::AttributePool::AttributePool">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 605,
   FQN="clang::AttributePool::AttributePool", NM="_ZN5clang13AttributePoolC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN5clang13AttributePoolC1EOS0_")
  //</editor-fold>
  public AttributePool(JD$Move _dparam, final AttributePool /*&&*/pool) {
    // : Factory(pool.Factory), Head(pool.Head) 
    //START JInit
    this./*&*/Factory=/*&*/pool.Factory;
    this.Head = pool.Head;
    //END JInit
    pool.Head = null;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AttributePool::getFactory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 609,
   FQN="clang::AttributePool::getFactory", NM="_ZNK5clang13AttributePool10getFactoryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZNK5clang13AttributePool10getFactoryEv")
  //</editor-fold>
  public AttributeFactory /*&*/ getFactory() /*const*/ {
    return Factory;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AttributePool::clear">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 611,
   FQN="clang::AttributePool::clear", NM="_ZN5clang13AttributePool5clearEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN5clang13AttributePool5clearEv")
  //</editor-fold>
  public void clear() {
    if ((Head != null)) {
      Factory.reclaimPool(Head);
      Head = null;
    }
  }

  
  /// Take the given pool's allocations and add them to this pool.
  //<editor-fold defaultstate="collapsed" desc="clang::AttributePool::takeAllFrom">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 619,
   FQN="clang::AttributePool::takeAllFrom", NM="_ZN5clang13AttributePool11takeAllFromERS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN5clang13AttributePool11takeAllFromERS0_")
  //</editor-fold>
  public void takeAllFrom(final AttributePool /*&*/ pool) {
    if ((pool.Head != null)) {
      takePool(pool.Head);
      pool.Head = null;
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AttributePool::~AttributePool">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 626,
   FQN="clang::AttributePool::~AttributePool", NM="_ZN5clang13AttributePoolD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN5clang13AttributePoolD0Ev")
  //</editor-fold>
  public void $destroy() {
    if ((Head != null)) {
      Factory.reclaimPool(Head);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AttributePool::create">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*not using allocate*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 630,
   FQN="clang::AttributePool::create", NM="_ZN5clang13AttributePool6createEPNS_14IdentifierInfoENS_11SourceRangeES2_NS_14SourceLocationEPN4llvm12PointerUnionIPNS_4ExprEPNS_13IdentifierLocEEEjNS_13AttributeList6SyntaxES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN5clang13AttributePool6createEPNS_14IdentifierInfoENS_11SourceRangeES2_NS_14SourceLocationEPN4llvm12PointerUnionIPNS_4ExprEPNS_13IdentifierLocEEEjNS_13AttributeList6SyntaxES4_")
  //</editor-fold>
  public AttributeList /*P*/ create(IdentifierInfo /*P*/ attrName, SourceRange attrRange, 
        IdentifierInfo /*P*/ scopeName, SourceLocation scopeLoc, 
        type$ptr<PointerUnion<Expr /*P*/ , IdentifierLoc /*P*/ >>/*P*/ args, /*uint*/int numArgs, 
        AttributeList.Syntax syntax) {
    return create(attrName, attrRange, 
        scopeName, scopeLoc, 
        args, numArgs, 
        syntax, 
        new SourceLocation());
  }
  public AttributeList /*P*/ create(IdentifierInfo /*P*/ attrName, SourceRange attrRange, 
        IdentifierInfo /*P*/ scopeName, SourceLocation scopeLoc, 
        type$ptr<PointerUnion<Expr /*P*/ , IdentifierLoc /*P*/ >>/*P*/ args, /*uint*/int numArgs, 
        AttributeList.Syntax syntax, 
        SourceLocation ellipsisLoc/*= SourceLocation()*/) {
    if (false) {    Object/*void P*/ memory = allocate($sizeof_AttributeList() + numArgs * $sizeof_PointerUnion$Expr$IdentifierLoc$P$P()); }
    type$ptr<PointerUnion<Expr /*P*/ , IdentifierLoc /*P*/ >> $tail$memory = create_type$ptr
        (new$T(new PointerUnion[numArgs], ()->null));
    return add(/*FIXME:NEW_EXPR*//*new (memory)*/ new AttributeList(attrName, new SourceRange(attrRange), 
            scopeName, new SourceLocation(scopeLoc), 
            args, numArgs, syntax, 
            new SourceLocation(ellipsisLoc), $tail$memory));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AttributePool::create">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*not using allocate*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 643,
   FQN="clang::AttributePool::create", NM="_ZN5clang13AttributePool6createEPNS_14IdentifierInfoENS_11SourceRangeES2_NS_14SourceLocationEPNS_13IdentifierLocERKNS_18AvailabilityChangeES9_S9_S4_PKNS_4ExprENS_13AttributeList6SyntaxES4_SC_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN5clang13AttributePool6createEPNS_14IdentifierInfoENS_11SourceRangeES2_NS_14SourceLocationEPNS_13IdentifierLocERKNS_18AvailabilityChangeES9_S9_S4_PKNS_4ExprENS_13AttributeList6SyntaxES4_SC_")
  //</editor-fold>
  public AttributeList /*P*/ create(IdentifierInfo /*P*/ attrName, SourceRange attrRange, 
        IdentifierInfo /*P*/ scopeName, SourceLocation scopeLoc, 
        IdentifierLoc /*P*/ Param, 
        final /*const*/ AvailabilityChange /*&*/ introduced, 
        final /*const*/ AvailabilityChange /*&*/ deprecated, 
        final /*const*/ AvailabilityChange /*&*/ obsoleted, 
        SourceLocation unavailable, 
        /*const*/ Expr /*P*/ MessageExpr, 
        AttributeList.Syntax syntax, 
        SourceLocation strict, /*const*/ Expr /*P*/ ReplacementExpr) {
    if (false) { Object/*void P*/ memory = allocate(AttributeFactory.Unnamed_enum.AvailabilityAllocSize.getValue()); }
    type$ptr $tail$memory = create_type$ptr(new$T(new Object[/*sizeof(ArgsUnion)*/1 + /*sizeof(AvailabilityData)*/1], ()->null));
    return add(/*FIXME:NEW_EXPR*//*new (memory)*/ new AttributeList(attrName, new SourceRange(attrRange), 
            scopeName, new SourceLocation(scopeLoc), 
            Param, introduced, deprecated, 
            obsoleted, new SourceLocation(unavailable), MessageExpr, 
            syntax, new SourceLocation(strict), ReplacementExpr, $tail$memory));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AttributePool::create">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 661,
   FQN="clang::AttributePool::create", NM="_ZN5clang13AttributePool6createEPNS_14IdentifierInfoENS_11SourceRangeES2_NS_14SourceLocationEPNS_13IdentifierLocES6_S6_NS_13AttributeList6SyntaxE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN5clang13AttributePool6createEPNS_14IdentifierInfoENS_11SourceRangeES2_NS_14SourceLocationEPNS_13IdentifierLocES6_S6_NS_13AttributeList6SyntaxE")
  //</editor-fold>
  public AttributeList /*P*/ create(IdentifierInfo /*P*/ attrName, SourceRange attrRange, 
        IdentifierInfo /*P*/ scopeName, SourceLocation scopeLoc, 
        IdentifierLoc /*P*/ Param1, 
        IdentifierLoc /*P*/ Param2, 
        IdentifierLoc /*P*/ Param3, 
        AttributeList.Syntax syntax) {
    if (false) {
      /*size_t*/int size = $sizeof_AttributeList() + 3 * $sizeof_PointerUnion$Expr$IdentifierLoc$P$P();
      Object/*void P*/ memory = allocate(size);
    }
    type$ptr<PointerUnion<Expr /*P*/ , IdentifierLoc /*P*/ >> $tail$memory = create_type$ptr
        (new$T(new PointerUnion[3], ()->null));    
    return add(/*FIXME:NEW_EXPR*//*new (memory)*/ new AttributeList(attrName, new SourceRange(attrRange), 
            scopeName, new SourceLocation(scopeLoc), 
            Param1, Param2, Param3, 
            syntax, $tail$memory));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AttributePool::createTypeTagForDatatype">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*not using allocate*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 675,
   FQN="clang::AttributePool::createTypeTagForDatatype", NM="_ZN5clang13AttributePool24createTypeTagForDatatypeEPNS_14IdentifierInfoENS_11SourceRangeES2_NS_14SourceLocationEPNS_13IdentifierLocENS_9OpaquePtrINS_8QualTypeEEEbbNS_13AttributeList6SyntaxE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN5clang13AttributePool24createTypeTagForDatatypeEPNS_14IdentifierInfoENS_11SourceRangeES2_NS_14SourceLocationEPNS_13IdentifierLocENS_9OpaquePtrINS_8QualTypeEEEbbNS_13AttributeList6SyntaxE")
  //</editor-fold>
  public AttributeList /*P*/ createTypeTagForDatatype(IdentifierInfo /*P*/ attrName, SourceRange attrRange, 
                          IdentifierInfo /*P*/ scopeName, SourceLocation scopeLoc, 
                          IdentifierLoc /*P*/ argumentKind, OpaquePtr<QualType> matchingCType, 
                          boolean layoutCompatible, boolean mustBeNull, 
                          AttributeList.Syntax syntax) {
    if (false) { Object/*void P*/ memory = allocate(AttributeFactory.Unnamed_enum.TypeTagForDatatypeAllocSize.getValue()); }    
    type$ptr $tail$memory = create_type$ptr(
            new$T(new Object[/*$sizeof_TypeTagForDatatypeData()*/1 + /*$sizeof_PointerUnion$Expr$IdentifierLoc$P$P()*/1], ()->null)
          );
    return add(/*FIXME:NEW_EXPR*//*new (memory)*/ new AttributeList(attrName, new SourceRange(attrRange), 
            scopeName, new SourceLocation(scopeLoc), 
            argumentKind, new OpaquePtr<QualType>(matchingCType), 
            layoutCompatible, mustBeNull, 
            syntax, $tail$memory));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AttributePool::createTypeAttribute">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*not using allocate*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 689,
   FQN="clang::AttributePool::createTypeAttribute", NM="_ZN5clang13AttributePool19createTypeAttributeEPNS_14IdentifierInfoENS_11SourceRangeES2_NS_14SourceLocationENS_9OpaquePtrINS_8QualTypeEEENS_13AttributeList6SyntaxE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN5clang13AttributePool19createTypeAttributeEPNS_14IdentifierInfoENS_11SourceRangeES2_NS_14SourceLocationENS_9OpaquePtrINS_8QualTypeEEENS_13AttributeList6SyntaxE")
  //</editor-fold>
  public AttributeList /*P*/ createTypeAttribute(IdentifierInfo /*P*/ attrName, SourceRange attrRange, 
                     IdentifierInfo /*P*/ scopeName, SourceLocation scopeLoc, 
                     OpaquePtr<QualType> typeArg, AttributeList.Syntax syntaxUsed) {
    if (false) { Object/*void P*/ memory = allocate($sizeof_AttributeList() + $sizeof_ptr()); }    
    // JAVA: we do not pass pointers, only objects
    return add(/*FIXME:NEW_EXPR*//*new (memory)*/ new AttributeList(attrName, new SourceRange(attrRange), 
            scopeName, new SourceLocation(scopeLoc), 
            new OpaquePtr<QualType>(typeArg), syntaxUsed));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AttributePool::createPropertyAttribute">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*not using allocate*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AttributeList.h", line = 699,
   FQN="clang::AttributePool::createPropertyAttribute", NM="_ZN5clang13AttributePool23createPropertyAttributeEPNS_14IdentifierInfoENS_11SourceRangeES2_NS_14SourceLocationES2_S2_NS_13AttributeList6SyntaxE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZN5clang13AttributePool23createPropertyAttributeEPNS_14IdentifierInfoENS_11SourceRangeES2_NS_14SourceLocationES2_S2_NS_13AttributeList6SyntaxE")
  //</editor-fold>
  public AttributeList /*P*/ createPropertyAttribute(IdentifierInfo /*P*/ attrName, SourceRange attrRange, 
                         IdentifierInfo /*P*/ scopeName, SourceLocation scopeLoc, 
                         IdentifierInfo /*P*/ getterId, IdentifierInfo /*P*/ setterId, 
                         AttributeList.Syntax syntaxUsed) {
    if (false) { Object/*void P*/ memory = allocate(AttributeFactory.Unnamed_enum.PropertyAllocSize.getValue()); }
    // JAVA: let's hope constructor will init it's this+1
    return add(/*FIXME:NEW_EXPR*//*new (memory)*/ new AttributeList(attrName, new SourceRange(attrRange), 
            scopeName, new SourceLocation(scopeLoc), 
            getterId, setterId, 
            syntaxUsed));
  }

  
  @Override public String toString() {
    return "" + "Factory=" + "[AttributeFactory]" // NOI18N
              + ", Head=" + Head; // NOI18N
  }
}
